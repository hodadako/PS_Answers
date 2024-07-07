package main

import (
	"bufio"
	"fmt"
	"os"
)

var stdio = bufio.NewReadWriter(
	bufio.NewReader(os.Stdin),
	bufio.NewWriter(os.Stdout),
)

func main() {
	defer stdio.Flush()
	fmt.Fprint(stdio, "\\    /\\\n )  ( ')\n(  /  )\n \\(__)|")
}
