package main

import (
    "fmt"
    "sort"
)

func main() {
    var a [5]int
    var sum int
    
    for i := 0; i < 5; i++ {
        fmt.Scan(&a[i])
        sum += a[i]
    }
    sort.Ints(a[:])
    
    fmt.Println(sum / 5)
    fmt.Println(a[2])
}
