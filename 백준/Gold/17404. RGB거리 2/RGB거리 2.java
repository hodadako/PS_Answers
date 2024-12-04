import java.io.*;
import java.util.*;

public class Main {
	public static class FastReader {
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

	    double nextDouble() {
	        return Double.parseDouble(next());
	    }

	    long nextLong() {
	        return Long.parseLong(next());
	    }
	}

	static int N;
	static int[][] prices;
	static int[][] dp1;
	static int[][] dp2;
	static int[][] colors1;
	static int[][] colors2;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		prices = new int[N][3];
		dp1 = new int[N][3];
		colors1 = new int[N][3];
		dp2 = new int[N][3];
		colors2 = new int[N][3];
		for (int i = 0; i < N; i++) {
			prices[i][0] = fr.nextInt();
			prices[i][1] = fr.nextInt();
			prices[i][2] = fr.nextInt();
			Arrays.fill(dp1[i], Integer.MAX_VALUE);
			Arrays.fill(dp2[i], Integer.MAX_VALUE);
		}

		dp1[0][0] = prices[0][0];
		dp1[0][1] = prices[0][1];
		dp1[0][2] = prices[0][2];
		colors1[0][0] = 0;
		colors1[0][1] = 1;
		colors1[0][2] = 2;

		for (int i = 1; i < N; i++) {
			if (i != N - 1) {
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						if (j != k && dp1[i - 1][j] + prices[i][k] < dp1[i][k]) {
							colors1[i][k] = colors1[i - 1][j];
							dp1[i][k] = dp1[i - 1][j] + prices[i][k];
						}
					}
				}
			} else {
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						if (j != k && dp1[i - 1][j] + prices[i][k] < dp1[i][k] && colors1[i - 1][j] != k) {
							colors1[i][k] = j;
							dp1[i][k] = dp1[i - 1][j] + prices[i][k];
						}
					}
				}
			}
		}

		dp2[N - 1][0] = prices[N - 1][0];
		dp2[N - 1][1] = prices[N - 1][1];
		dp2[N - 1][2] = prices[N - 1][2];
		colors2[N - 1][0] = 0;
		colors2[N - 1][1] = 1;
		colors2[N - 1][2] = 2;

		for (int i = N - 2; i >= 0; i--) {
			if (i != 0) {
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						if (j != k && dp2[i + 1][j] + prices[i][k] < dp2[i][k]) {
							colors2[i][k] = colors2[i + 1][j];
							dp2[i][k] = dp2[i + 1][j] + prices[i][k];
						}
					}
				}
			} else {
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						if (j != k && dp2[i + 1][j] + prices[i][k] < dp2[i][k] && colors2[i + 1][j] != k) {
							colors2[i][k] = j;
							dp2[i][k] = dp2[i + 1][j] + prices[i][k];
						}
					}
				}
			}
		}

		System.out.println(Math.min(Arrays.stream(dp1[N - 1]).min().getAsInt(), Arrays.stream(dp2[0]).min().getAsInt()));
	}
}