import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K, answer = (int)1e9;
	static int[][] map;
	static boolean[][][][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		M = fr.nextInt();
		K = fr.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M][K + 1][2];
		for (int i = 0; i < N; i++) {
			String now =  fr.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = Character.getNumericValue(now.charAt(j));
			}
		}

//		if (N == 1 && M == 1) {
//			System.out.println(1);
//			return;
//		}

		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {0, 0, 0, 1, K});
		visited[0][0][K][0] = true;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			if (now[0] == N - 1 && now[1] == M - 1) {
				answer = Math.min(answer, now[3]);
				continue;
			}
			boolean flag = false;
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (map[nx][ny] == 0 && !visited[nx][ny][now[4]][1 - now[2]]) {
						visited[nx][ny][now[4]][1 - now[2]] = true;
						queue.add(new int[] {nx, ny, 1 - now[2], now[3] + 1, now[4]});
					} else if (map[nx][ny] == 1 && now[4] > 0 && now[2] == 0 && !visited[nx][ny][now[4] - 1][1 - now[2]]) {
						visited[nx][ny][now[4] - 1][1 - now[2]] = true;
						queue.add(new int[] {nx, ny, 1 - now[2], now[3] + 1, now[4] - 1});
					}
				}
			}

			if (!visited[now[0]][now[1]][now[4]][1 - now[2]]) {
//				System.out.println("check");
				visited[now[0]][now[1]][now[4]][1 - now[2]] = true;
//					System.out.println("now = " + now[0] + " " + now[1]);
				queue.add(new int[] {now[0], now[1], 1 - now[2], now[3] + 1, now[4]});
			}
		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(costs[i][j] + " ");
//			}
//			System.out.println();
//		}
//
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				for (int k = 0; k < K + 1; k++) {
//					System.out.print(Arrays.toString(visited[i][j][k]) + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}

		System.out.println(answer == (int) 1e9 ? -1 : answer);
	}

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

		double nextDouble() {
			return Double.parseDouble(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}
}