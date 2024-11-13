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
		int next, distance;

		public Node(int next, int distance) {
			this.next = next;
			this.distance = distance;
		}
	}

	static int N, M, R;
	static int[] distances = new int[100_001];
	static boolean[] visited = new boolean[100_001];
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt() - 1;

		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}

		Arrays.fill(distances, -1);

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		bfs();

		for (int i = 0; i < N; i++) {
			System.out.println(distances[i]);
		}
	}

	static void bfs() {
		LinkedList<Node> q = new LinkedList<>();
		visited[R] = true;
		distances[R] = 0;
		q.add(new Node(R, 0));
		while (!q.isEmpty()) {
			Node now = q.poll();
			for (int v : graph.get(now.next)) {
				if (!visited[v]) {
					visited[v] = true;
					distances[v] = now.distance + 1;
					q.add(new Node(v, now.distance + 1));
				}
			}
		}
	}
}