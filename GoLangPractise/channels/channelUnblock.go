package main

import (
	"fmt"
	"time"
)

func main() {
	ch1 := make(chan int)
	go func() {
		fmt.Println("enter ")
		for res := range ch1 {
			fmt.Println("res:", res)
		}
		fmt.Println("exit")

	}()
	ch1 <- 1
	ch1 <- 2
	ch1 <- 3
	ch1 <- 4
	ch1 <- 5
	close(ch1)
	time.Sleep(time.Second)
}
