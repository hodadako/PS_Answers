import java.io.*;
import java.util.*;

public class Main {
	static int R, C, K, W, chocolate = 0;
	static int[][] map;
	static int[][] temperatures;
	/*
		1: 방향이 오른쪽인 온풍기가 있음
		2: 방향이 왼쪽인 온풍기가 있음
		3: 방향이 위인 온풍기가 있음
		4: 방향이 아래인 온풍기가 있음
	 */
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static boolean[][] visited;
	static int[][][] windDirections = {{{0, 1}, {-1, 1}, {1, 1}}, {{0, -1}, {-1, -1}, {1, -1}},
		{{-1, 0}, {-1, -1}, {-1, 1}}, {{1, 0}, {1, -1}, {1, 1}}};
	static HashMap<Point, HashSet<Point>> walls = new HashMap<>();
	static ArrayList<Heater> heaters = new ArrayList<>();
	static ArrayList<Point> searchPoints = new ArrayList<>();


	/*
	-1, -1 | -1, 0 | -1, 1
	0, -1 | 0, 0 | 0, 1
	1, -1 | 1, 0 | 1, 1
	대각선으로 이동할 때는 x 먼저 확인하고 그다음 x y 같이 확인하고
	 */
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		R = fr.nextInt();
		C = fr.nextInt();
		K = fr.nextInt();
		map = new int[R][C];
		temperatures = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int now = fr.nextInt() - 1;
				map[i][j] = now;
				if (0 <= now && now <= 3) {
					heaters.add(new Heater(i, j, now));
				} else if (now == 4) {
					searchPoints.add(new Point(i, j));
				}
			}
		}

		W = fr.nextInt();
		for (int i = 0; i < W; i++) {
			makeWall(fr.nextInt() - 1, fr.nextInt() - 1, fr.nextInt());
		}

		// System.out.println("heaters = " + heaters);

		for (int i = 0; i < 101; i++) {
			// 모든 온풍기에서 따뜻한 바람이 나옴
			for (Heater h : heaters) {
				heatUp2(h);
				// printTemp("온풍기 작동");
			}


			// 온도 조절
			evenTemp();

			// printTemp("온도 조절 후");

			// 온도 감소
			chill();

			// printTemp("온도 감소 후");
			// 초콜릿 먹기
			chocolate++;

			// 조사하는 모든 칸의 온도가 K 이상인지 검사하기.
			if (inspect()) {
				break;
			}
		}

		// System.out.println("searchPoints = " + searchPoints);
		System.out.println(chocolate);
	}


	static void makeWall(int x, int y, int t) {
		Point p1 = new Point(x, y);
		Point p2 = (t == 0) ? new Point(x - 1, y) : new Point(x, y + 1);
		walls.computeIfAbsent(p1, k -> new HashSet<>()).add(p2);
		walls.computeIfAbsent(p2, k -> new HashSet<>()).add(p1);
	}

	static void heatUp2(Heater heater) {
		visited = new boolean[R][C];
		int nx = heater.x + dx[heater.dir];
		int ny = heater.y + dy[heater.dir];
		if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
			return;
		}
		dfs(nx, ny, 5, heater);
	}

	static void heatUp(Heater heater) {
		visited = new boolean[R][C];
		int nx = heater.x + dx[heater.dir];
		int ny = heater.y + dy[heater.dir];
		int k = 5;
		Point start = new Point(nx, ny, k);
		if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
			return;
		}

		visited[nx][ny] = true;
		temperatures[nx][ny] += k;

		LinkedList<Point> q = new LinkedList<>();
		q.add(start);
		while (!q.isEmpty()) {
			Point point = q.poll();

			if (point.k == 0) {
				break;
			}

			for (int i = 0; i < 3; i++) {
				int dx = windDirections[heater.dir][i][0];
				nx = point.x + dx;
				int dy = windDirections[heater.dir][i][1];
				ny = point.y + dy;

				if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
					continue;
				}

				if (dx == 0 || dy == 0) {
					int temp = point.k;

					while (true) {
						if (checkWall(new Point(nx - dx, ny - dy), new Point(nx, ny))) {
							visited[nx][ny] = true;
							break;
						}
						visited[nx][ny] = true;
						temperatures[nx][ny] += temp - 1;
						temp--;
						nx += dx;
						ny += dy;

						if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
							break;
						}
					}
				} else {
					Point diagonal = new Point(point.x + dx, point.y);
					if (checkWall(point, diagonal) && checkWall(diagonal, new Point(nx, ny))) {
					} else if (!visited[nx][ny]) {
						visited[nx][ny] = true;
						temperatures[nx][ny] += point.k - 1;
						q.add(new Point(nx, ny, point.k - 1));
					}
				}
			}
		}
	}

	static void dfs(int x, int y, int count, Heater heater) {
		if (count == 0) {
			return;
		}
		visited[x][y] = true;
		temperatures[x][y] += count;
		for (int i = 0; i < 3; i++) {
			int dx = windDirections[heater.dir][i][0];
			int dy = windDirections[heater.dir][i][1];
			int nx = x + dx;
			int ny = y + dy;
			if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny]) {
				continue;
			}

			if(dx == 0 || dy == 0) {
				if (!checkWall(new Point(x, y), new Point(nx, ny))) {
					dfs(nx, ny, count - 1, heater);
				}
			} else if (heater.dir == 0 || heater.dir == 1) {
				Point diagonal = new Point(x + dx, y);
				if (!checkWall(new Point(x, y), diagonal)) {
					if (!checkWall(diagonal, new Point(x + dx, y + dy))) {
						dfs(nx, ny, count - 1, heater);
					}
				}
			} else if (heater.dir == 2 || heater.dir == 3) {
				Point diagonal = new Point(x, y + dy);
				if (!checkWall(new Point(x, y), diagonal)) {
					if (!checkWall(diagonal, new Point(x + dx, y + dy))) {
						dfs(nx, ny, count - 1, heater);
					}
				}
			}
		}
	}

	static void evenTemp() {
		int[][] newTemp = new int[R][C];
		boolean[][][] visited = new boolean[R][C][4];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				newTemp[i][j] = temperatures[i][j];
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
						continue;
					}

					if (checkWall(new Point(i, j), new Point(nx, ny))) {
						continue;
					}

					int indegreeDir = reverseDirection(k);
					if (!visited[nx][ny][indegreeDir]) {
						visited[nx][ny][indegreeDir] = true;
						visited[i][j][k] = true;
						int diff = Math.abs(temperatures[i][j] - temperatures[nx][ny]) / 4;
						if (temperatures[i][j] > temperatures[nx][ny]) {
							newTemp[i][j] -= diff;
							newTemp[nx][ny] += diff;
						} else if (temperatures[i][j] < temperatures[nx][ny]) {
							newTemp[i][j] += diff;
							newTemp[nx][ny] -= diff;
						}
					}
				}
			}
		}

		temperatures = newTemp;
	}

	static int reverseDirection(int dir) {
		if (dir == 0) {
			return 1;
		} else if (dir == 1) {
			return 0;
		} else if (dir == 2) {
			return 3;
		} else
			return 2;

	}

	static boolean checkWall(Point o, Point other) {
		return walls.containsKey(o) && walls.get(o).contains(other);
	}

	static void chill() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (i == 0 || i == R - 1 || j == 0 || j == C - 1) {
					if (temperatures[i][j] > 0) temperatures[i][j]--;
				}
			}
		}
	}

	static boolean inspect() {
		for (Point sp : searchPoints) {
			if (temperatures[sp.x][sp.y] < K) {
				return false;
			}
		}
		return true;
	}

	static void printTemp(String result) {
		System.out.println(result);
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(temperatures[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("________________________________________");
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

	static class Point {
		int x, y, k;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Point(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Point) {
				Point p = (Point)o;
				return x == p.x && y == p.y;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return (x + "," + y).hashCode();
		}
	}

	static class Heater {
		int x, y, dir;

		public Heater(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "(" + x + "," + y + "," + dir + ")";
		}
	}
}

