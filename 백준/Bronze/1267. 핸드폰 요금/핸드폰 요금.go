package main

import (
    "bufio"
    "fmt"
    "os"
    "strings"
    "strconv"
)

var (
    N, Y, M, answer int
    nums string
    reader *bufio.Reader
    writer *bufio.Writer
)

func main() {
    reader = bufio.NewReader(os.Stdin)
    writer = bufio.NewWriter(os.Stdout)
    defer writer.Flush()
    
    fmt.Fscanln(reader, &N)
    nums, _ = reader.ReadString('\n')
    strSlice := strings.Fields(nums)
    
    intSlice := make([]int, N)
    for i, v := range strSlice {
		intSlice[i], _ = strconv.Atoi(v)
	}

    for i := range intSlice {
        Y += calcY(intSlice[i])
        M += calcM(intSlice[i])
    }
    
    if Y == M {
        fmt.Fprintln(writer, "Y M", Y)
    } else if (Y < M) {
        fmt.Fprintln(writer, "Y", Y)
    } else {
        fmt.Fprintln(writer, "M", M)
    }
}

func calcY(time int) int {
    return (time / 30 + 1) * 10
}

func calcM(time int) int {
    return (time / 60 + 1) * 15
}
