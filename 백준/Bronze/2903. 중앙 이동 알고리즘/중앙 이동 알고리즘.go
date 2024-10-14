package main

import (
    "bufio"
    "fmt"
    "os"
)

var (
     N int
    reader *bufio.Reader
    writer *bufio.Writer
)

func main() {
    reader = bufio.NewReader(os.Stdin)
    writer = bufio.NewWriter(os.Stdout)
    defer writer.Flush()
    
    fmt.Fscanln(reader, &N)
    
    result := moveCenter(N)
    
    fmt.Fprintln(writer, result * result)
}

func moveCenter(number int) int {
    if number == 0 {
        return 2
    } 
    return moveCenter(number - 1) * 2 - 1
}