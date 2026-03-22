package main

import (
	"fmt"
	"math/rand"
)

func repeatFunc(done <-chan int, fn func() int) <-chan int {
	out := make(chan int)

	go func() {
		fmt.Println("repeatFunc called ")

		defer close(out)
		for {
			select {
			case <-done:
				return
			case out <- fn():
			}
		}
	}()
	return out
}

func main() {
	randFunc := func() int {
		randNumbber := rand.Intn(10)
		fmt.Println("Random gen called ", randNumbber)
		return randNumbber
	}
	done := make(chan int)
	ch := repeatFunc(done, randFunc)
	for rando := range ch {
		fmt.Println("Random:", rando)
	}

}
