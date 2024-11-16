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
		int x, y, height;

		public Node(int x, int y, int height) {
			this.x = x;
			this.y = y;
			this.height = height;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(o.height, height);
		}
	}

	static int N, M, answer;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

	public static void main(String[] args) {
		FastReader sc = new FastReader();

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				pq.add(new Node(i, j, map[i][j]));
			}
		}

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			if (!visited[node.x][node.y]) {
				bfs(node.x, node.y);
			}
		}
		System.out.println(answer);
	}

	private static void bfs(int i, int j) {
		boolean found = true;
		LinkedList<Node> q = new LinkedList<>();
		visited[i][j] = true;
		q.add(new Node(i, j, map[i][j]));

		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int k = 0; k < 8; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}

				if (!visited[nx][ny]) {
					if (map[nx][ny] <= cur.height) {
						visited[nx][ny] = true;
						q.add(new Node(nx, ny, map[nx][ny]));
					}
				}
			}
		}

		// System.out.println("found = " + found);
		// print();

		if (found) {
			answer++;
		}
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("_________________");
	}
}