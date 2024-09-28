package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var (
	A, B, C, D int
	answer     string
	reader     *bufio.Reader
	writer     *bufio.Writer
)

func main() {
	reader = bufio.NewReader(os.Stdin)
	writer = bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	fmt.Fscanln(reader, &A, &B, &C, &D)
	s1 := strconv.Itoa(A) + strconv.Itoa(B)
	s2 := strconv.Itoa(C) + strconv.Itoa(D)
	i1, _ := strconv.Atoi(s1)
	i2, _ := strconv.Atoi(s2)
	fmt.Fprintln(writer, i1 + i2)

}
