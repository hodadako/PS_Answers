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

	static int N, M, answer;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

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

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && graph[i][j] == 0) {
					bfs(i, j);
					// print();
				}
			}
		}

		System.out.println(answer);
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(visited[i][j] ? 1 + " " : 0 + " ");
			}
			System.out.println();
		}
		System.out.println("________________");
	}

	private static int ted(int i) {
		return i == 0 ? N - 1 : 0;
	}

	private static int boo(int i) {
		return i == 0 ? M - 1 : 0;
	}

	private static void bfs(int x, int y) {
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y));
		visited[x][y] = true;
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 || nx >= N) {
					nx = ted(cur.x);
				}

				if (ny < 0 || ny >= M) {
					ny = boo(cur.y);
				}

				if (!visited[nx][ny] && graph[nx][ny] == 0) {
					visited[nx][ny] = true;
					queue.add(new Node(nx, ny));
				}
			}
		}
		answer++;
	}
}