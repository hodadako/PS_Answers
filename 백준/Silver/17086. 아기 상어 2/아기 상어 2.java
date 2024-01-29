import java.io.*;
import java.util.*;

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

	static final int INF = Integer.MAX_VALUE;
	static int N, M;
	static int[][] distances;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

	static class Node{
		int x, y, distance;

		public Node(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		M = fr.nextInt();

		ArrayList<Node> sharks = new ArrayList<>();

		distances = new int[N][M];
		graph = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				graph[i][j] = fr.nextInt();
				if (graph[i][j] == 1) {
					sharks.add(new Node(i, j));
				}
			}
		}

		for (int i = 0; i < N; i++) {
			Arrays.fill(distances[i], INF);
		}

		for (Node shark : sharks) {
			bfs(shark.x, shark.y, sharks);
			distances[shark.x][shark.y] = 0;
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				answer = Math.max(answer, distances[i][j]);
			}
		}

		System.out.println(answer);
	}

	private static void bfs(int x, int y, ArrayList<Node> sharks) {
		LinkedList<Node> q = new LinkedList<>();
		q.add(new Node(x, y, 0));
		visited = new boolean[N][M];

		for (Node shark : sharks) {
			visited[shark.x][shark.y] = true;
		}

		while (!q.isEmpty()) {
			Node now = q.removeFirst();
			for (int i = 0; i < 8; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				if (!visited[nx][ny]) {
					q.add(new Node(nx, ny, now.distance + 1));
					distances[nx][ny] = Math.min(distances[nx][ny], now.distance + 1);
					visited[nx][ny] = true;
				}
			}
		}
	}
}