package main

import (
    "fmt"
    "bufio"
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
    
    for i := 0; i < N; i++ {
        for j := 0; j < i + 1; j++ {
            fmt.Fprint(writer, "*")
        }
        fmt.Fprintln(writer)
    }
}
