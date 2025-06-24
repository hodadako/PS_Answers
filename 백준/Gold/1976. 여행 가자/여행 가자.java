import java.io.*;
import java.util.*;

public class Main {
	static final int INF = (int)1e9;
	static int N, M;
	static int[][] graph, costs;
	static int[] order;

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		M = fr.nextInt();
		graph = new int[N][N];
		costs = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(costs[i], INF);
			for (int j = 0; j < N; j++) {
				graph[i][j] = fr.nextInt();
				if (i == j) {
					costs[i][j] = 0;
				}
				if (graph[i][j] == 1) {
					costs[i][j] = 1;
				}
			}
		}
		order = new int[M];
		for (int i = 0; i < M; i++) {
			order[i] = fr.nextInt() - 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					costs[j][k] = Math.min(costs[j][k], costs[j][i] + costs[i][k]);
				}
			}
		}
		//
		// for (int i = 0; i < N; i++) {
		// 	System.out.println(Arrays.toString(costs[i]));
		// }
		for (int i = 0; i < M - 1; i++) {
			if (costs[order[i]][order[i + 1]] == INF) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
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