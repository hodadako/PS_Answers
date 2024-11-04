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
		int x, y, time;

		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public int hashCode() {
			return (x + "," + y).hashCode();
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Node) {
				Node other = (Node) o;
				return x == other.x && y == other.y;
			}
			return false;
		}

		public void setTime(int time) {
			this.time = time;
		}
	}
	// 불을 먼저 옮기는데 해당 불이 옮겨간 시간을 기록하면 될듯?


	static int R, C;
	static int sx, sy;
	static char[][] graph;
	static boolean[][] visited;
	static int[][] onFireTime;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		R = fr.nextInt();
		C = fr.nextInt();

		graph = new char[R][C];
		visited = new boolean[R][C];
		onFireTime = new int[R][C];

		for (int i = 0; i < R; i++) {
			Arrays.fill(onFireTime[i], -1);
		}

		for (int i = 0; i < R; i++) {
			String now = fr.next();
			for (int j = 0; j < C; j++) {
				graph[i][j] = now.charAt(j);
				if (graph[i][j] == 'J') {
					sx = i;
					sy = j;
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (graph[i][j] == 'F') {
					spreadFire(i, j);
				}
			}
		}

		System.out.println(bfs());
		//
		// for (int i = 0; i < R; i++) {
		// 	System.out.println(Arrays.toString(onFireTime[i]));
		// }
	}

	private static String bfs() {
		visited = new boolean[R][C];
		LinkedList<Node> q = new LinkedList<>();
		q.add(new Node(sx, sy, 0));
		visited[sx][sy] = true;

		int minTime = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0|| ny < 0 || nx >= R || ny >= C) {
					minTime = Math.min(minTime, cur.time + 1);
					continue;
				}

				if (graph[nx][ny] == '.' && !visited[nx][ny] && (onFireTime[nx][ny] > cur.time + 1 || onFireTime[nx][ny] == -1)) {
					visited[nx][ny] = true;
					q.add(new Node(nx, ny, cur.time + 1));
				}
			}
		}
		return minTime == Integer.MAX_VALUE ? "IMPOSSIBLE" : String.valueOf(minTime);
	}

	private static void spreadFire(int fx, int fy) {
		visited = new boolean[R][C];
		LinkedList<Node> q = new LinkedList<>();
		q.add(new Node(fx, fy, 0));
		visited[fx][fy]	= true;
		replaceTime(fx, fy, 0);

		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
					continue;
				}

				if ((graph[nx][ny] == '.' || graph[nx][ny] == 'J' || graph[nx][ny] == 'F') && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new Node(nx, ny, cur.time + 1));
					replaceTime(nx, ny, cur.time + 1);
				}
			}
		}
	}

	private static void replaceTime(int nx, int ny, int time) {
		if (onFireTime[nx][ny] == -1) {
			onFireTime[nx][ny] = time;
			return;
		}
		onFireTime[nx][ny] = Math.min(onFireTime[nx][ny], time);
	}
}