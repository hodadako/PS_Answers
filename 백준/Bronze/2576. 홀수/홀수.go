package main

import (
    "fmt"
)

func main() {
    var n, min, sum int
    min = 100000000
    for i := 0; i < 7; i++ {
        fmt.Scanln(&n)
        if n % 2 != 0 {
            sum += n
            if n < min {
                min = n
            }
        } 
    }
    
    if sum == 0{
        fmt.Println(-1)
    } else {
        fmt.Println(sum)
        fmt.Println(min)
    }
}