import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static final long MOD = 1000;
	static int N;
	static long B;
	static long[][] start;
	static HashMap<Long, long[][]> dp = new HashMap<>();

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		B = fr.nextLong();
		start = new long[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				start[i][j] = fr.nextLong() % MOD;
			}
		}

		long count = 1;
		dp.put(count, start);
		print(solve(B));
	}

	static void print(long[][] a) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	static long[][] solve(long a) {
		if (a == 1) {
			return dp.get(1L);
		} else if (dp.containsKey(a)) {
			return dp.get(a);
		} else {
			long[][] result;
			if (a % 2 != 0) {
				result = multiply(multiply(solve(a / 2), solve(a / 2)), solve(1));
			} else {
				result = multiply(solve(a / 2), solve(a / 2));
			}
			dp.put(a, result);
			return result;
		}
	}

	static long[][] multiply(long[][] a, long[][] b) {
		long[][] c = new long[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					c[i][j] += (a[i][k] * b[k][j]) % MOD;
				}
				c[i][j] %= MOD;
			}
		}
		return c;
	}

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
}