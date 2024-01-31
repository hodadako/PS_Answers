import java.io.*;
import java.util.*;

class Main {
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

	static int N, M, R;
	static int[] orders;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		M = fr.nextInt();
		R = fr.nextInt();

		orders = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			int u = fr.nextInt();
			int v = fr.nextInt();
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		bfs(R);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(orders[i] + "\n");
		}

		System.out.println(sb.toString());
	}

	private static void bfs(int start) {
		LinkedList<Integer> q = new LinkedList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		q.add(start);
		visited[start] = true;

		int count = 1;
		while (!q.isEmpty()) {

			int now = q.poll();
			orders[now] = count;
			count++;

			for (int next : graph.get(now)) {
				if (!visited[next]) {
					pq.add(next);
					visited[next] = true;
				}
			}

			while (!pq.isEmpty()) {
				q.add(pq.poll());
			}
		}
	}
}