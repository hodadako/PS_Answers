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

	static int N, M;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	static class Node {
		int now, depth;

		public Node(int now, int depth) {
			this.now = now;
			this.depth = depth;
		}
	}

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		System.out.println(bfs());
	}

	private static long bfs() {
		boolean[] visited = new boolean[N + 1];
		int[] distances = new int[N + 1];
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(new Node(1, 0));
		visited[1] = true;
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[1] = 0;

		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			if (cur.depth > 1) {
				continue;
			}
			for (int i : graph.get(cur.now)) {
				if (!visited[i]) {
					visited[i] = true;
					distances[i] = 1;
					queue.add(new Node(i , cur.depth + 1));
				}
			}
		}
		// System.out.println(Arrays.toString(distances));

		int total = 0;
		for (int i = 1; i < N + 1; i++) {
			if (distances[i] != Integer.MAX_VALUE) {
				total += distances[i];
			}
		}
		return total;
	}
}