package main

import (
    "fmt"
    "sort"
)

func main() {
    var nums [3]int
    
    for i:= 0; i < 3; i++ {
        fmt.Scan(&nums[i])
    }
    
    sort.Ints(nums[:])
    
    fmt.Printf("%d %d %d\n", nums[0], nums[1], nums[2])
}