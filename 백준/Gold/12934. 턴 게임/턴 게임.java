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

	static long a, b;

	public static void main(String[] args) {
		FastReader sc = new FastReader();

		a = sc.nextLong();
		b = sc.nextLong();

		long n = getN(a, b);

		if (a == 0 && b == 0) {
			System.out.println(0);
			return;
		}


		if (n == -1) {
			System.out.println(-1);
		} else {
			int answer = 0;
			for (long i = n; i >= 1 ; i--) {
				if (a >= i) {
					a -= i;
					answer++;
				}
			}
			System.out.println(answer);
		}
	}

	static long getN(long a, long b) {
		long sum = a + b;

		double sqrt = Math.sqrt(1 + 8 * sum);

		// System.out.println(sqrt);

		if (Math.abs(sqrt - (long) sqrt) > (long) 1e-9) {
			return -1;
		}

		return (-1 + (long)sqrt) / 2;
	}
}