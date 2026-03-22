package main

import (
	"fmt"
	"net/http"
	"time"
)

// Global list of websites
var websites = []string{
	"https://www.google.com",
	"https://www.github.com",
	"https://www.golang.org",
	"https://www.rapido.bike",
	"https://thissitedoesnotexist.tld",
}

func main() {
	statusChan := make(chan string)

	go printStatuses(statusChan)

	for idx, url := range websites {
		if idx > 1 {
			time.Sleep(10 * time.Second)
		}
		go checkWebsite(url, statusChan)
	}

}

// checkWebsite makes a GET request and sends a status message to the channel
func checkWebsite(url string, c chan<- string) {
	client := &http.Client{Timeout: 5 * time.Second}

	resp, err := client.Get(url)
	if err != nil {
		c <- fmt.Sprintf("%s -> ERROR: %v", url, err)
		return
	}
	defer resp.Body.Close()

	c <- fmt.Sprintf("%s -> %s (%d)", url, resp.Status, resp.StatusCode)
}

// printStatuses receives and prints results for all websites
func printStatuses(c <-chan string) {
	for range websites {
		fmt.Println(<-c)
	}
}
