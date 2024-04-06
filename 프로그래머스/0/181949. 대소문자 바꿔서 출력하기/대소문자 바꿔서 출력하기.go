package main

import "fmt"

func main() {
    var input string
    fmt.Scan(&input)
    
    converted := ""
    
    for _, char := range input {
        if 'a' <= char && char <= 'z' {
            converted += string(char - 32)
        } else if 'A' <= char && char <= 'Z' {
            converted += string(char + 32)
        } else {
            converted += string(char)
        }
    }
    
    fmt.Println(converted)
}