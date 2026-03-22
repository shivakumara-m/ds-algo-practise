package main

import "fmt"

func main() {
	ch1 := make(chan int)
	go func() {
		ch1 <- 2
		ch1 <- 3
		ch1 <- 4
		ch1 <- 5
		ch1 <- 6
	}()

	fromF2, ok := <-ch1
	fmt.Println("from channel ", fromF2, "is channel ok ", ok)
}
