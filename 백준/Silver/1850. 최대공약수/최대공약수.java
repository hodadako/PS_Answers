import java.math.BigInteger;
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

		long nextLong() {
			return Long.parseLong(next());
		}

		BigInteger nextBigInteger() {
			return new BigInteger(next());
		}
	}

	public static void main(String[] args) {
		FastReader sc = new FastReader();

		long a1 = sc.nextLong();
		long b1 = sc.nextLong();
		long result = 0;
		if (a1 >= b1) {
			result = euclidean(a1, b1);
		} else {
			result = euclidean(b1, a1);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result; i++) {
			sb.append('1');
		}
		System.out.println(sb.toString());
	}

	static long euclidean(long a, long b) {
		long c = a % b;
		if (c == 0) {
			return b;
		}
		return euclidean(b, c);
	}
}