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

	static int M, N, K;
	static boolean[][] visited;
	static ArrayList<Integer> areas = new ArrayList<>();
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};


	public static void main(String[] args) {
		FastReader fr = new FastReader();
		M = fr.nextInt();
		N = fr.nextInt();
		K = fr.nextInt();
		visited = new boolean[M][N];

		for (int i = 0; i < K; i++) {
			int x1 = fr.nextInt();
			int y1 = fr.nextInt();
			int x2 = fr.nextInt();
			int y2 = fr.nextInt();
			for (int j = y1; j < y2; j++) {
				for (int k = x1; k < x2; k++) {
					visited[j][k] = true;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
				}
			}
		}

		Collections.sort(areas);

		System.out.println(areas.size());
		for (int i : areas) {
			System.out.print(i + " ");
		}
	}

	private static void bfs(int x, int y) {
		LinkedList<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		visited[x][y] = true;
		int size = 1;

		while (!q.isEmpty()) {
			Node now = q.removeFirst();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
					continue;
				}
				if (!visited[nx][ny]) {
					visited[nx][ny] = true;
					size++;
					q.add(new Node(nx, ny));
				}
			}
		}

		areas.add(size);
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}