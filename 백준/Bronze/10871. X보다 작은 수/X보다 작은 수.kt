import java.util.*;

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val n = nextInt()
    val x = nextInt()
    for (int in 1..n) {
        val now = nextInt()
        if (now < x) {
            println(now)
        }
    }
}