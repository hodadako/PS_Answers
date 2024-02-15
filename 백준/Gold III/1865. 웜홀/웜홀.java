import java.io.*;
import java.util.*;

class Main {
	static final int INF = (int) 2e9;
	static ArrayList<Edge> graph;
	static int TC, N, M, W;
	static int[][] distance;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		TC = fr.nextInt();
		for (int i = 0; i < TC; i++) {
			graph = new ArrayList<>();
			N = fr.nextInt();
			M = fr.nextInt();
			W = fr.nextInt();

			distance = new int[N + 1][N + 1];
			for (int j = 0; j < M; j++) {
				int s = fr.nextInt();
				int e = fr.nextInt();
				int t = fr.nextInt();

				graph.add(new Edge(s, e, t));
				graph.add(new Edge(e, s, t));
			}

			for (int j = 0; j < W; j++) {
				int s = fr.nextInt();
				int e = fr.nextInt();
				int t = fr.nextInt();

				graph.add(new Edge(s, e, -t));
			}

			sb.append((bellmanFord() ? "YES" : "NO") + "\n");
		}

		System.out.println(sb.toString());
	}

	private static boolean bellmanFord() {
		int[] distance = new int[N + 1];
		Arrays.fill(distance, INF);
		distance[1] = 0;
		for (int i = 0; i < N - 1; i++) {
			for (Edge edge : graph) {
				if (distance[edge.end] > distance[edge.start] + edge.weight) {
					distance[edge.end] = distance[edge.start] + edge.weight;
				}
			}
		}

		for (Edge edge : graph) {
			if (distance[edge.end] > distance[edge.start] + edge.weight) {
				return true;
			}
		}
		return false;
	}

	private static void print() {
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < N + 1; j++) {
				System.out.print(distance[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("_______________");
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
	}

	static class Edge {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
}