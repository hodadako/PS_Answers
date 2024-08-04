package main

import (
    "fmt"
)

func main() {
    var a, b, c, d int
    game := []string{"D", "C", "B", "A", "E"} 
    for i := 0; i < 3; i++ {
        fmt.Scanln(&a, &b, &c, &d)
        fmt.Println(game[a + b + c + d])
    }
}
