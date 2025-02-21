import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N, ansCount = 0, ax, ay, aDir, sCount = 0, sx, sy, sDir;
	static char[][] map;
	static int[][][] answer;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) {
		FastReader sc = new FastReader();

		N = sc.nextInt();
		map = new char[N][N];
		answer = new int[N][N][2];
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'B' && sCount < 2) {
					if (sCount == 1) {
						if (Math.abs(i - sx) == 1) {
							sDir = 0;
						} else if (Math.abs(j - sy) == 1) {
							sDir = 1;
						}
					}
					sx = i;
					sy = j;
					sCount++;
				} else if (map[i][j] == 'E' && ansCount < 2) {
					if (ansCount == 1) {
						// System.out.println("ax = " + ax);
						// System.out.println("ay = " + ay);
						if (Math.abs(i - ax) == 1) {
							aDir = 0;
						} else if (Math.abs(j - ay) == 1) {
							aDir = 1;
						}
					}
					ax = i;
					ay = j;
					ansCount++;
				}
			}
		}

		// System.out.println(ax + " " + ay + " " + aDir);
		// System.out.println(sx + " " + sy + " " + sDir);

		bfs();
		// print();
		System.out.println(answer[ax][ay][aDir]);
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 2; k++) {
					System.out.print(answer[i][j][k] + " ");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("__________________");
	}

	private static void bfs() {
		LinkedList<int[]> q = new LinkedList<>();
		answer[sx][sy][sDir] = -1;
		q.add(new int[] {sx, sy, sDir, 0});
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now[0];
				int ny = now[1];
				// 세로
				if (now[2] == 0) {
					if (i < 2) {
						nx += dx[i];
						ny += dy[i];
						if (answer[nx][ny][now[2]] != 0) {
							continue;
						}
						nx += dx[i];
						ny += dy[i];
						if (isOutOfBounds(nx, ny) || map[nx][ny] == '1') {
							continue;
						}
						nx -= dx[i];
						ny -= dy[i];
						q.add(new int[] {nx, ny, now[2], now[3] + 1});
						answer[nx][ny][now[2]] = now[3] + 1;
					} else {
						int upX = nx + dx[0] + dx[i];
						int upY = ny + dy[0] + dy[i];
						int downX = nx + dx[1] + dx[i];
						int downY = ny + dy[1] + dy[i];
						nx += dx[i];
						ny += dy[i];
						if (isOutOfBounds(nx, ny) || isOutOfBounds(upX, upY) || isOutOfBounds(downX, downY)
							|| answer[nx][ny][now[2]] != 0 || map[nx][ny] == '1' || map[upX][upY] == '1'
							|| map[downX][downY] == '1') {
							continue;
						}
						q.add(new int[] {nx, ny, now[2], now[3] + 1});
						answer[nx][ny][now[2]] = now[3] + 1;
					}
				} else {
					if (i >= 2) {
						nx += dx[i];
						ny += dy[i];
						if (answer[nx][ny][now[2]] != 0) {
							continue;
						}
						nx += dx[i];
						ny += dy[i];
						if (isOutOfBounds(nx, ny) || map[nx][ny] == '1') {
							continue;
						}
						nx -= dx[i];
						ny -= dy[i];
						q.add(new int[] {nx, ny, now[2], now[3] + 1});
						answer[nx][ny][now[2]] = now[3] + 1;
					} else {
						int leftX = nx + dx[2] + dx[i];
						int leftY = ny + dy[2] + dy[i];
						int rightX = nx + dx[3] + dx[i];
						int rightY = ny + dy[3] + dy[i];
						nx += dx[i];
						ny += dy[i];
						if (isOutOfBounds(nx, ny) || isOutOfBounds(leftX, leftY) || isOutOfBounds(rightX, rightY)
							|| answer[nx][ny][now[2]] != 0 || map[nx][ny] == '1' || map[leftX][leftY] == '1'
							|| map[rightX][rightY] == '1') {
							continue;
						}
						q.add(new int[] {nx, ny, now[2], now[3] + 1});
						answer[nx][ny][now[2]] = now[3] + 1;
					}
				}
			}

			int nx = now[0];
			int ny = now[1];

			if (now[2] == 0) {
				int upLeftX = nx + dx[0] + dx[2];
				int upLeftY = ny + dy[0] + dy[2];
				int midLeftX = nx + dx[2];
				int midLeftY = ny + dy[2];
				int downLeftX = nx + dx[1] + dx[2];
				int downLeftY = ny + dy[1] + dy[2];
				int upRightX = nx + dx[0] + dx[3];
				int upRightY = ny + dy[0] + dy[3];
				int midRightX = nx + dx[3];
				int midRightY = ny + dy[3];
				int downRightX = nx + dx[1] + dx[3];
				int downRightY = ny + dy[1] + dy[3];
				if (isOutOfBounds(upLeftX, upLeftY) || isOutOfBounds(midLeftX, midLeftY)
					|| isOutOfBounds(downLeftX, downLeftY)
					|| isOutOfBounds(midRightX, midRightY) || isOutOfBounds(upRightX, upRightY) || isOutOfBounds(
					downRightX, downRightY) || map[upLeftX][upLeftY] == '1' || map[midLeftX][midLeftY] == '1'
					|| map[downLeftX][downLeftY] == '1' || map[upRightX][upRightY] == '1'
					|| map[midRightX][midRightY] == '1' || map[downRightX][downRightY] == '1'
					|| answer[nx][ny][1 - now[2]] != 0) {
					continue;
				}
				q.add(new int[] {nx, ny, 1 - now[2], now[3] + 1});
				answer[nx][ny][1 - now[2]] = now[3] + 1;
			} else {
				int leftUpX = nx + dx[2] + dx[0];
				int leftUpY = ny + dy[2] + dy[0];
				int midUpX = nx + dx[0];
				int midUpY = ny + dy[0];
				int rightUpX = nx + dx[3] + dx[0];
				int rightUpY = ny + dy[3] + dy[0];
				int leftDownX = nx + dx[2] + dx[1];
				int leftDownY = ny + dy[2] + dy[1];
				int midDownX = nx + dx[1];
				int midDownY = ny + dy[1];
				int rightDownX = nx + dx[3] + dx[1];
				int rightDownY = ny + dy[3] + dy[1];
				if (isOutOfBounds(leftUpX, leftUpY) || isOutOfBounds(midUpX, midUpY) || isOutOfBounds(rightUpX,
					rightUpY) || isOutOfBounds(leftDownX, leftDownY) || isOutOfBounds(midDownX,
					midDownY) || isOutOfBounds(rightDownX, rightDownY) || map[leftUpX][leftUpY] == '1'
					|| map[midUpX][midUpY] == '1' || map[rightUpX][rightUpY] == '1' || map[leftDownX][leftDownY] == '1'
					|| map[midDownX][midDownY] == '1' || map[rightDownX][rightDownY] == '1' || answer[nx][ny][1 - now[2]] != 0) {
					continue;
				}
				q.add(new int[] {nx, ny, 1 - now[2], now[3] + 1});
				answer[nx][ny][1 - now[2]] = now[3] + 1;
			}
		}
	}

	static boolean isOutOfBounds(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= N;
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
	}
}