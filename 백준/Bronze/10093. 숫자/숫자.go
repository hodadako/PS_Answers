package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var (
	A, B   int64
	answer string
	reader *bufio.Reader
	writer *bufio.Writer
)

func main() {
	reader = bufio.NewReader(os.Stdin)
	writer = bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	fmt.Fscanln(reader, &A, &B)
	if A == B {
		fmt.Fprintln(writer, B-A)
	} else if A > B { 
		fmt.Fprintln(writer, A-B-1)
		for i := B + 1; i < A; i++ {
			answer += strconv.FormatInt(i, 10) + " "
		}
		fmt.Fprintln(writer, answer)
    } else {
        fmt.Fprintln(writer, B-A-1)
        for i := A + 1; i < B; i++ {
            answer += strconv.FormatInt(i, 10) + " "
        }
        fmt.Fprintln(writer, answer)
    }
}
