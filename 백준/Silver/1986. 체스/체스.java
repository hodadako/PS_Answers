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


	static int N, M, qCount, kCount, pCount;
	static char[][] map;
	static boolean[][] visited;
	static ArrayList<Node> pawns = new ArrayList<>();
	static ArrayList<Node> knights = new ArrayList<>();
	static ArrayList<Node> queens = new ArrayList<>();
	static int[] qx = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] qy = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int[] kx = {2, 2, 1, -1, -2, -2, 1, -1};
	static int[] ky = {1, -1, 2, 2, 1, -1, -2, -2};
	static int[] px = {-1, 0, 1, 0};
	static int[] py = {0, 1, 0, -1};

	public static void main(String[] args) {
		FastReader sc = new FastReader();

		N = sc.nextInt();
		M = sc.nextInt();

		map = new char[N][M];
		visited = new boolean[N][M];

		qCount = sc.nextInt();
		for (int i = 0; i < qCount; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			map[x][y] = 'Q';
			queens.add(new Node(x, y));
		}

		kCount = sc.nextInt();
		for (int i = 0; i <kCount; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			map[x][y] = 'K';
			knights.add(new Node(x, y));
		}

		pCount = sc.nextInt();
		for (int i = 0; i < pCount; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			map[x][y] = 'P';
			pawns.add(new Node(x, y));
		}

		for (Node pawn : pawns) {
			visited[pawn.x][pawn.y] = true;
		}

		for (Node knight : knights) {
			visited[knight.x][knight.y] = true;
			for (int i = 0; i < 8; i++) {
				int nx = knight.x + kx[i];
				int ny = knight.y + ky[i];
				if (isOutOfBound(nx, ny)) {
					continue;
				}
				// System.out.println(nx + " " + ny);
				visited[nx][ny] = true;
			}
		}

		for (Node queen : queens) {
			visited[queen.x][queen.y] = true;
			for (int i = 0; i < 8; i++) {
				int nx = queen.x;
				int ny = queen.y;
				while (!isOutOfBound(nx, ny)) {
					nx += qx[i];
					ny += qy[i];
					if (isOutOfBound(nx, ny)) {
						break;
					}
					if (map[nx][ny] == 'Q' || map[nx][ny] == 'K' || map[nx][ny] == 'P') {
						break;
					}
					visited[nx][ny] = true;
				}
			}
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// System.out.print((visited[i][j] ? 1 : 0) + " ");
				if (!visited[i][j]) {
					answer++;
				}
			}
			// System.out.println();
		}
		System.out.println(answer);
	}

	static boolean isOutOfBound(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= M;
	}
}