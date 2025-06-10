import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long[][] matrix;
	static long[][] dp;

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		matrix = new long[N][2];
		dp = new long[500][501];
		for (int i = 0; i < N; i++) {
			matrix[i][0] = fr.nextLong();
			matrix[i][1] = fr.nextLong();
		}

		for (int i = 0; i < 500; i++) {
			Arrays.fill(dp[i], Long.MAX_VALUE);
			dp[i][i] = 0;
		}

		for (int len = 2; len <= N; len++) {
			for (int i = 0; i <= N - len; i++) {
				int j = i + len - 1;
				for (int k = i; k < j; k++) {
					long cost = dp[i][k] + dp[k + 1][j] + matrix[i][0] * matrix[k][1] * matrix[j][1];
					dp[i][j] = Math.min(dp[i][j], cost);
				}
			}
		}
		System.out.println(dp[0][N - 1]);
	}

	static class FastReader {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try { st = new StringTokenizer(br.readLine()); }
				catch (IOException e) { e.printStackTrace(); }
			}
			return st.nextToken();
		}
		int nextInt() { return Integer.parseInt(next()); }
		long nextLong() { return Long.parseLong(next()); }
	}
}
