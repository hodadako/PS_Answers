import java.util.*;
import java.io.*;

class Main {
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

	    long nextLong() {
	        return Long.parseLong(next());
	    }

	    double nextDouble() {
	        return Double.parseDouble(next());
	    }
	}

	static int N, answer, result = 0;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};


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
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = fr.nextInt();
			}
		}
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (map[j][k] <= i) {
						visited[j][k] = true;
					}
				}
			}

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (!visited[j][k]) {
						bfs(j, k);
					}
				}
			}
			result = Math.max(result, answer);
			visited = new boolean[N][N];
			answer = 0;
		}
		System.out.println(result);
	}

	private static void bfs(int x, int y) {
		LinkedList<Node> q = new LinkedList<>();
		visited[x][y] = true;
		q.add(new Node(x, y));

		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				if (!visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new Node(nx, ny));
				}
			}
		}
		answer++;
	}
}