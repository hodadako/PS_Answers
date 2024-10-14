package main

import (
    "bufio"
    "fmt"
    "os"
)

var (
    S string
    korea, yonsei string
    reader *bufio.Reader
    writer *bufio.Writer
    k, y int
    entered []string
)

func main() {
    reader = bufio.NewReader(os.Stdin)
    writer = bufio.NewWriter(os.Stdout)
    defer writer.Flush()
    
    k, y = 0, 0
    entered = []string{}
    
    fmt.Fscanln(reader, &S)
    
    for i:= 0; i < len(S); i++ {
        moveIndex(S[i])
    }
    
    fmt.Fprintln(writer, entered[0])
}

func moveIndex(b byte) {
    korea := "KOREA"
    yonsei := "YONSEI"
    if k != len(korea){
        if korea[k] == b {
            k++
        }
        if k == len(korea) {
            entered = append(entered, korea)
        }
    } 
    
    if y != len(yonsei){
        if yonsei[y] == b {
            y++
        }
        if y == len(yonsei) {
            entered = append(entered, yonsei)
        }
    } 
}
