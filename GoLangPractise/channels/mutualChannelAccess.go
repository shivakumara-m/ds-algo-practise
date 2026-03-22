package main

import (
	"fmt"
)

func main() {
	ch1 := make(chan int)
	ch2 := make(chan int)

	go func() {
		fmt.Println("enter ")
		ch1 <- 1
		fmt.Println("from channel 2 ", <-ch2)
	}()
	ch2 <- 10
	fmt.Println(" from channel 1 ", <-ch1)
}
