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

		public Node(int now, int distance) {
			this.now = now;
			this.distance = distance;
		}
	}

	static int N, M, start, end;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] chon;

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		start = sc.nextInt();
		end = sc.nextInt();
		M = sc.nextInt();
		chon = new int[N + 1];
		Arrays.fill(chon, -1);

		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		bfs();
		System.out.println(chon[end]);
	}

	static void bfs() {
		LinkedList<Node> q = new LinkedList<>();
		q.add(new Node(start, 0));
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i : graph.get(cur.now)) {
				if(chon[i] == -1) {
					chon[i] = cur.distance + 1;
					q.add(new Node(i, cur.distance + 1));
				}
			}
		}
	}
}