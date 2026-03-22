package main

import (
	"fmt"
)

func main() {
	ch1 := make(chan int)
	go func() {
		ch1 <- 1
		fmt.Println("exit")

	}()

	fmt.Println("enter ", <-ch1)
}
