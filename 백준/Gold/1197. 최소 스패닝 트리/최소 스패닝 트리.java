import java.util.*;
import java.io.*;

public class Main {
	static int V, E;
	static PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
	static int[] parent = new int[10001];
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		V = fr.nextInt();
		E = fr.nextInt();

		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < E; i++) {
			pq.add(new Edge(fr.nextInt(), fr.nextInt(), fr.nextInt()));
		}
		int answer = 0;
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (!isCycle(edge.from, edge.to)) {
				union(edge.from, edge.to);
				answer += edge.cost;
			}
		}
		System.out.println(answer);
	}

	static int parent(int i) {
		if (parent[i] != i) {
			return parent(parent[i]);
		}
		return parent[i];
	}

	static void union(int a, int b) {
		int aParent = parent(a);
		int bParent = parent(b);
		if (aParent < bParent) {
			parent[bParent] = aParent;
		} else {
			parent[aParent] = bParent;
		}
	}

	static boolean isCycle(int a, int b) {
		return parent(a) == parent(b);
	}

	static class Edge {
		int from, to, cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}

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
	}
}