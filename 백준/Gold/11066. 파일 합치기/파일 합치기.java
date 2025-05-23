import java.io.*;
import java.util.*;

public class Main {
	static int T;
	static int[] arr;
	static int[] prefixSum;
	static int[][] dp;

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		T = fr.nextInt();

		while (T-- > 0) {
			int k = fr.nextInt();
			arr = new int[k + 1];
			prefixSum = new int[k + 1];
			dp = new int[k + 1][k + 1];

			for (int i = 1; i <= k; i++) {
				arr[i] = fr.nextInt();
				prefixSum[i] = prefixSum[i - 1] + arr[i];
			}

			for (int len = 2; len <= k; len++) {
				for (int i = 1; i <= k - len + 1; i++) {
					int j = i + len - 1;
					dp[i][j] = Integer.MAX_VALUE;
					for (int mid = i; mid < j; mid++) {
						dp[i][j] = Math.min(dp[i][j],
								dp[i][mid] + dp[mid + 1][j] + prefixSum[j] - prefixSum[i - 1]);
					}
				}
			}

			System.out.println(dp[1][k]);
		}
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
	}
}
