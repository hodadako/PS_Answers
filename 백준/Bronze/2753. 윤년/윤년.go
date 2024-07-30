package main;

import (
    "fmt"
)

func main() {
    var n int
    var isLeapYear int
    
    fmt.Scanln(&n)
    isLeapYear = 0
    
    if n % 4 == 0 && n % 100 != 0 || n % 400 == 0 {
        isLeapYear = 1
    }
    
    fmt.Println(isLeapYear)
}