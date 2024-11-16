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

	static class Node implements Comparable<Node> {
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.distance, o.distance);
		}

		int now, distance;

		public Node(int now, int distance) {
			this.now = now;
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

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int distance = sc.nextInt();
			graph.get(a).add(new Node(b, distance));
			graph.get(b).add(new Node(a, distance));
		}

		prim();
	}

	static void prim() {
		boolean[] visited = new boolean[N + 1]; 
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0)); 
		int totalDistance = 0; 

		while (!pq.isEmpty()) {
			Node node = pq.poll();

			if (visited[node.now]) continue;

			visited[node.now] = true;
			totalDistance += node.distance;

			for (Node v : graph.get(node.now)) {
				if (!visited[v.now]) {
					pq.add(new Node(v.now, v.distance));
				}
			}
		}

		System.out.println(totalDistance);
	}

}