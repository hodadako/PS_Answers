package main

import (
    "fmt"
)

func main() {
    var a, b, c int
    var triple, double, once int
    
    fmt.Scanln(&a, &b, &c)
    var visited [7]int
    visited[a] += 1
    visited[b] += 1
    visited[c] += 1
    
    for i := 1; i <= 6; i++ {
        if visited[i] == 3 {
            triple = i
        } else if visited[i] == 2 {
            double = i
        } else if visited[i] == 1 {
            once = i
        }
    }
    
    if triple != 0 {
        fmt.Println(10000 + triple * 1000)
    } else if double != 0 {
        fmt.Println(1000 + double * 100)
    } else {
        fmt.Println(once * 100)
    }
}