package main

import (
    "fmt"
    "os"
    "bufio"
    )

var (
    S string
    flag, answer int
    reader *bufio.Reader
    writer *bufio.Writer
)

func main() {
    reader = bufio.NewReader(os.Stdin)
    writer = bufio.NewWriter(os.Stdout)
    defer writer.Flush()
    
    fmt.Fscanln(reader, &S)
    
    answer = 1
    
    for _, b := range S {
        if flag == syllableType(b) {
            answer = 0
            break
        }
        flag = syllableType(b)
    }
    
    fmt.Fprintln(writer, answer)
}

func syllableType(b rune) int {
    if b == 'a' || b == 'e' || b == 'i' || b == 'o' || b == 'u'{
        return -1
    }
    return 1
}