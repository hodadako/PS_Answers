import java.io.*;
import java.util.*;

public class Main {
	static int TC, A, B, count = Integer.MAX_VALUE;
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		TC = sc.nextInt();
		for (int i = 0; i < TC; i++) {
			A = sc.nextInt();
			B = sc.nextInt();
			bfs(A, B, "");
		}
		System.out.println(answer);
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

	static class Node {
		int now;
		String s;

		public Node(int now, String s) {
			this.now = now;
			this.s = s;
		}
	}

	static void bfs(int cur, int target, String str) {
		boolean[] visited = new boolean[10000];
		String[] values = new String[10000];
		LinkedList<Node> q = new LinkedList<>();
		q.add(new Node(cur, str));
		visited[cur] = true;
		while (!q.isEmpty()) {
			Node n = q.poll();

			int d = n.now * 2 > 9999 ? n.now * 2 % 10000 : n.now * 2;
			int s = n.now - 1 < 0 ? 9999 : n.now - 1;
			int l = n.now % 1000 * 10 + n.now / 1000;
			int r = n.now / 10 + n.now % 10 * 1000;
			
			if (!visited[d]) {
				visited[d] = true;
				values[d] = n.s + "D";
				q.add(new Node(d, n.s + "D"));
			}

			if (!visited[s]) {
				visited[s] = true;
				values[s] = n.s + "S";
				q.add(new Node(s, n.s + "S"));
			}

			if (!visited[l]) {
				visited[l] = true;
				values[l] = n.s + "L";
				q.add(new Node(l, n.s + "L"));
			}

			if (!visited[r]) {
				visited[r] = true;
				values[r] = n.s + "R";
				q.add(new Node(r, n.s + "R"));
			}
		}

		answer.append(values[target]).append("\n");
	}
}