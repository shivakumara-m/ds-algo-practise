package main

import (
	"fmt"
	"math/rand"
)

func main() {
	done := make(chan int)
	out := make(chan int)
	go func() {
		defer close(out)
		for {
			select {
			case <-done:
				return
			case out <- rand.Int():
			}
		}
	}()

	for rando := range out {
		fmt.Println("Random:", rando)
	}
}
