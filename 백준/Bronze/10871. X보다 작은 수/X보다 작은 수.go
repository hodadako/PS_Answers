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

	var n, k, now int
	fmt.Fscan(stdio, &n, &k)

	for i := 1; i <= n; i++ {
		fmt.Fscan(stdio, &now)
		if now < k {
			fmt.Fprint(stdio, now, " ")
		}
	}
}
