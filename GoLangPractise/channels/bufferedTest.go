package main

import (
	"fmt"
	"time"
)

func main() {
	ch1 := make(chan int, 0)
	go func() {
		fmt.Println("Received value:", <-ch1)
		fmt.Println("Received value:", <-ch1)
		fmt.Println("Received value:", <-ch1)
		v, ok := <-ch1
		fmt.Println("Received value:", v, "ok:", ok)
	}()
	ch1 <- 1
	ch1 <- 2
	close(ch1)
	time.Sleep(time.Second)
}
