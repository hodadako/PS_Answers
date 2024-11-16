import java.util.*;
import java.io.*;

public class Main {
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}
	}

	static int a, b;

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		a = sc.nextInt();
		b = sc.nextInt();

		int answer1 = 0;
		int answer2 = 0;

		int sx = 1;
		int sy = 1;

		while (sx != a || sy != b) {
			// System.out.println("a = " + a);
			// System.out.println("b = " + b);
			if (a > b) {
				a -= b;
				answer1++;
			} else if (b > a) {
				b -= a;
				answer2++;
			}
		}

		System.out.println(answer1 + " " + answer2);
	}
}