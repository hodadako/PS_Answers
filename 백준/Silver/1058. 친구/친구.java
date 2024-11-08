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

	static int N;
	static int[][] graph;
	static int[][] distances;

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();

		int answer = 0;

		distances = new int[N][N];
		graph = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] charArr = sc.next().toCharArray();
			for (int j = 0; j < N; j++) {
				distances[i][j] = charArr[j] == 'Y' ? 1 : (int)1e9;
			}
		}

		for (int i = 0; i < N; i++) {
			distances[i][i] = 0;
		}

		// print();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (i == j || j == k || i == k) {
						continue;
					}

					distances[j][k] = Math.min(distances[j][k], distances[j][i] + distances[i][k]);
				}
			}
			// print();
			// System.out.println("_________");
		}

		for (int i = 0; i < N; i++) {
			int count = 0;
			for (int j = 0; j < N; j++) {
				if (distances[i][j] == 1 || distances[i][j] == 2) {
					count++;
				}
			}
			answer = Math.max(count, Math.max(count, answer));
		}

		System.out.println(answer);
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(distances[i][j] + " ");
			}
			System.out.println();
		}
	}
}