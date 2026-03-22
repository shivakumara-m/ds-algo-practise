package main

import "fmt"

func main() {
	ch1 := make(chan int)
	ch2 := make(chan int)
	go func() {
		ch1 <- 1
		fromF2	, ok := <-ch2
		fmt.Println("from channel ", fromF2, " is channel ok ", ok)
	}()
	ch2 <- 2
	fromF1, ok := <-ch1
	fmt.Println("from channel ", fromF1, " is channel ok ", ok)
}
