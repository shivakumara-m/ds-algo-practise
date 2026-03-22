package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
	"sync"
)

type Job struct {
	id 	 int
	fileName string
	keyWord  string
}

func worker(jobs <-chan Job, results chan<- string, wg *sync.WaitGroup) {

	defer wg.Done()

	for job := range jobs {
		fmt.Println("Worker processing job:", job.id)

		fmt.Println("Processing job with filename:", job.fileName)
		file, err := os.Open(job.fileName)
		if err != nil {
			continue
		}

		scanner := bufio.NewScanner(file)
		for scanner.Scan() {
			line := scanner.Text()
			if strings.Contains(line, job.keyWord) {
				results <- line
				break
			}
		}
		file.Close()
	}
}

func main() {
	jobs := make(chan Job)
	results := make(chan string)
	var wg sync.WaitGroup

	// fixed worker pool
	numWorkers := 3
	wg.Add(numWorkers)
	for i := 0; i < numWorkers; i++ {
		go worker(jobs, results, &wg)
	}

	// send jobs
	go func() {
		jobs <- Job{1, "./logFiles/logFile1.txt", "image"}
		jobs <- Job{2, "./logFiles/logFile2.txt", "product"}
		jobs <- Job{3, "./logFiles/logFile3.txt", "ajaxFilter"}
		close(jobs)
	}()

	// close results when workers finish
	go func() {
		wg.Wait()
		close(results)
	}()

	// consume results
	for r := range results {
		fmt.Println("FOUND:", r)
	}
}
