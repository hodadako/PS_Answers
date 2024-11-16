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

	static class Node {
		int now, distance;

		public Node(int next, int distance) {
			this.now = next;
			this.distance = distance;
		}
	}

	static int N, M;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}

		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			System.out.println(bfs(start, end));
		}
	}

	static int bfs(int start, int end) {
		boolean[] visited = new boolean[N + 1];
		LinkedList<Node> q = new LinkedList<>();
		visited[start] = true;
		q.add(new Node(start, 0));
		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.now == end) {
				return cur.distance;
			}

			for (Node next : graph.get(cur.now)) {
				if (!visited[next.now]) {
					visited[next.now] = true;
					q.add(new Node(next.now, cur.distance + next.distance));
				}
			}
		}
		return 0;
	}
}