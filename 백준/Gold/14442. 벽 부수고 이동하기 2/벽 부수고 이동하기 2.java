import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static final int INF = (int) 1e9;
	static int[][] map, costs;
	static boolean[][][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) {
		int answer = -1;
		FastReader fr = new FastReader();
		N = fr.nextInt();
		M = fr.nextInt();
		K = fr.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String now =  fr.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = Character.getNumericValue(now.charAt(j));
			}
		}
		visited = new boolean[N][M][100];

		costs = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(costs[i], INF);
		}
		LinkedList<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0, 0, 1});
		visited[0][0][0] = true;
		while (!queue.isEmpty()) {
			int[] now =  queue.poll();
			int x = now[0], y = now[1];
			if (x == N - 1 && y == M - 1) {
				answer = now[3];
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (map[nx][ny] == 0 && !visited[nx][ny][now[2]]) {
						visited[nx][ny][now[2]] = true;
						queue.add(new int[] {nx, ny, now[2], now[3] + 1});
					} else if (map[nx][ny] == 1 && !visited[nx][ny][now[2] + 1] && now[2] < K) {
						visited[nx][ny][now[2] + 1] = true;
						queue.add(new int[] {nx, ny, now[2] + 1, now[3] + 1});
					}
				}
			}
		}
		System.out.println(answer);
	}

	public static void printVisited() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(Arrays.toString(visited[i][j]) + " ");
			}
			System.out.println();
		}
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(costs[i][j] + " ");
			}
			System.out.println();
		}
	}

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

		double nextDouble() {
			return Double.parseDouble(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}
}