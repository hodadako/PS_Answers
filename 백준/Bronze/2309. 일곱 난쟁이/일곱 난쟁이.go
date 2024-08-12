package main

import (
	"fmt"
	"sort"
)

func main() {
	var arr [9]int
	var found bool
	for i := 0; i < 9; i++ {
		fmt.Scan(&arr[i])
	}

	for i := 0; i < 9; i++ {
		for j := 0; j < 9; j++ {
			if i != j {
				var sum int
				var now []int
				for k := 0; k < 9; k++ {
					if k != i && k != j {
						sum += arr[k]
						now = append(now, arr[k])
					}
				}

				if sum == 100 {
					sort.Ints(now)
					for l := 0; l < 7; l++ {
						fmt.Println(now[l])
					}
					found = true
					break
				}
			}
			if found {
				break
			}
		}
		if found {
			break
		}
	}
}
