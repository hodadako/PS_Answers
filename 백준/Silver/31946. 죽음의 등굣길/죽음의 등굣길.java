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
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, JUMP_STRENGTH;
	static int[][] graph;
	static boolean[][] visited;

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		M = fr.nextInt();

		graph = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				graph[i][j] = fr.nextInt();
			}
		}

		JUMP_STRENGTH = fr.nextInt();

		System.out.println(bfs() ? "ALIVE" : "DEAD");
	}

	static boolean bfs() {
		LinkedList<Node> q = new LinkedList<>();
		q.offer(new Node(0, 0));
		visited[0][0] = true;
		int color = graph[0][0];

		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = cur.x - 100; i < cur.x + 100; i++) {
				for (int j = cur.y - 100; j < cur.y + 100; j++) {
					if (i < 0 || j < 0 || i >= N || j >= M) {
						continue;
					}

					if (getManhattan(cur.x, cur.y, i, j) <= JUMP_STRENGTH && !visited[i][j] && graph[i][j] == color) {
						visited[i][j] = true;
						q.add(new Node(i, j));
					}
				}
			}
		}
		return visited[N - 1][M - 1] && graph[0][0] == graph[N - 1][M - 1];
	}

	public static int getManhattan(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}