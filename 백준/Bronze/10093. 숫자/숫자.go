package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

var (
	A, B   int64
	reader *bufio.Reader
	writer *bufio.Writer
)

func main() {
	reader = bufio.NewReader(os.Stdin)
	writer = bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	fmt.Fscanln(reader, &A, &B)
	if A == B {
		fmt.Fprintln(writer, 0)
	} else if A > B {
		fmt.Fprintln(writer, A-B-1)
		var sb strings.Builder
		for i := B + 1; i < A; i++ {
			sb.WriteString(strconv.FormatInt(i, 10))
			sb.WriteString(" ")
		}
		fmt.Fprintln(writer, strings.TrimSpace(sb.String()))
	} else {
		fmt.Fprintln(writer, B-A-1)
		var sb strings.Builder
		for i := A + 1; i < B; i++ {
			sb.WriteString(strconv.FormatInt(i, 10))
			sb.WriteString(" ")
		}
		fmt.Fprintln(writer, strings.TrimSpace(sb.String()))
	}
}
