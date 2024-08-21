package main

import (
    "fmt"
    "bufio"
    "os"
)

var (
    start, end int
    reader *bufio.Reader
    writer *bufio.Writer
)

func main() {
    reader = bufio.NewReader(os.Stdin)
    writer = bufio.NewWriter(os.Stdout)
    defer writer.Flush()
    
    intSlice := []int{}
    for i := 1; i < 21; i++ {
        intSlice = append(intSlice, i)
    }
    
    for i := 0; i < 10; i++ {
        fmt.Fscanln(reader, &start, &end)
        for j, k := start - 1, end - 1; j < k; j, k = j + 1, k - 1 {
            intSlice[j], intSlice[k] = intSlice[k], intSlice[j]
        }
    }
    
    for i := range intSlice {
        fmt.Fprint(writer, intSlice[i])
        fmt.Fprint(writer, " ")
    }
}
