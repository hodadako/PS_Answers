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
		int n = sc.nextInt();
		long[] dp = new long[n + 1];
		dp[0] = 1;
		dp[1] = 3;
		for (int i = 2; i < n + 1; i++) {
			dp[i] = 2 * dp[i - 1] % 9901 + dp[i - 2] % 9901;
		}

		System.out.println(dp[n] % 9901);
	}
}