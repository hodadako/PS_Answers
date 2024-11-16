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

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		long a = sc.nextLong();
		long b = sc.nextLong();

		long n = b - a;

		long boundary = (long)Math.round(Math.sqrt(n));
		if (boundary * boundary - boundary < n && n <= boundary * boundary ) {
			System.out.println(2 * boundary - 1);
		} else if (boundary < n && n <= boundary * boundary + boundary) {
			System.out.println(2 * boundary);
		} else {
			System.out.println(n);
		}
	}
}