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
	}

	static int N, M;

	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};


	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();

		while (true) {
			N = fr.nextInt();
			M = fr.nextInt();

			int[][] map = new int[M][N];

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = fr.nextInt();
				}
			}

			if (N == 0 && M == 0) {
				break;
			}

			int answer = 0;

			boolean[][] visited = new boolean[M][N];

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] != 0) {
						LinkedList<Node> q = new LinkedList<>();
						visited[i][j] = true;
						q.add(new Node(i, j));

						while (!q.isEmpty()) {
							Node node = q.poll();
							for (int k = 0; k < 8; k++) {
								int nx = node.x + dx[k];
								int ny = node.y + dy[k];
								if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
									continue;
								}
								if (!visited[nx][ny]) {
									if (map[nx][ny] == 1) {
										visited[nx][ny] = true;
										q.add(new Node(nx, ny));
									}
								}
							}
						}
						answer++;
					}
				}
			}
			System.out.println(answer);
		}
	}

	private static void print(boolean[][] visited) {
		System.out.println("___________________");
		for (int i = 0; i < visited.length ; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
	}
}