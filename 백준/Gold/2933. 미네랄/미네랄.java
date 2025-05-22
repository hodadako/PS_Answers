import java.io.*;
import java.util.*;

public class Main {
	static int R, C, N;
	static boolean left = true;
	static boolean[][] visited;
	static ArrayList<int[]> clusters = new ArrayList<>();
	static char[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		R = fr.nextInt();
		C = fr.nextInt();
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = fr.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		N = fr.nextInt();
		// print();
		for (int i = 0; i < N; i++) {
			int height = fr.nextInt();
			// System.out.println("height = " + height);
			throwStick(height);
			// print();
			// System.out.println("____________________");
			visited = new boolean[R][C];
			for (int j = 0; j < R; j++) {
				for (int k = 0; k < C; k++) {
					if (!visited[j][k] && map[j][k] == 'x') {
						findCluster(j, k);
					}
				}
			}

			moveDown();
			clusters.clear();
			// System.out.println("___________");
		}
		print();
	}

	static void moveDown() {
		int[] heights = new int[C];
		int next = (int) 1e9;
		int direction = 2;
		for (int[] c : clusters) {
			heights[c[1]] = Math.max(heights[c[1]], c[0]);
			map[c[0]][c[1]] = '.';
		}

		// System.out.println("heights = " + Arrays.toString(heights));

		for (int i = 0; i < C; i++) {
			if (heights[i] == 0) {
				continue;
			}
			int nx = heights[i];
			int ny = i;
			while (true) {
				nx += dx[direction];
				ny += dy[direction];
				if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
					// System.out.println("nx = " + nx);
					// System.out.println("heights = " + heights[i]);
					next = Math.min(next, nx - 1 - heights[i]);
					break;
				}

				if (map[nx][ny] == 'x') {
					// System.out.println("nx = " + nx);
					// System.out.println("heights = " + heights[i]);
					next = Math.min(next, nx - 1 - heights[i]);
					break;
				}
			}
		}

		// System.out.println(next);
		for (int[] c : clusters) {
			map[c[0] + next][c[1]] = 'x';
		}
	}

	static void findCluster(int x, int y) {
		LinkedList<int[]> q = new LinkedList<>();
		ArrayList<int[]> temp = new ArrayList<>();
		int[] now = new int[]{x, y};
		q.add(now);
		boolean result = false;
		visited[x][y] = true;
		temp.add(now);
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny]) {
					continue;
				}
				if (map[nx][ny] == 'x') {
					int[] next = new int[]{nx, ny};
					q.add(next);
					temp.add(next);
					visited[nx][ny] = true;
					if (nx == R - 1) {
						result = true;
					}
				}
			}
		}

		if (!result) {
			clusters.addAll(temp);
		}
	}

	static void throwStick(int height) {
		int direction = left ? 1 : 3;
		int start = left ? 0 : C - 1;
		int nx = R - height;
		int ny = start;

		if (map[nx][ny] == 'x') {
			map[nx][ny] = '.';
		} else {
			while (true) {
				nx += dx[direction];
				ny += dy[direction];
				if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
					break;
				}
				if (map[nx][ny] == 'x') {
					map[nx][ny] = '.';
					break;
				}
			}
		}

		left = !left;
	}

	static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
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