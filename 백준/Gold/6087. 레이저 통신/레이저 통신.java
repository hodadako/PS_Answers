import java.io.*;
import java.util.*;

public class Main {
	static int W, H, answer = Integer.MAX_VALUE, sx = -1, sy, ex, ey;
	static char[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		W = fr.nextInt();
		H = fr.nextInt();
		map = new char[H][W];
		for (int i = 0; i < H; i++) {
			String s = fr.next();
			for (int j = 0; j < W; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'C') {
					if (sx == -1) {
						sx = i;
						sy = j;
					} else {
						ex = i;
						ey = j;
					}
				}
			}
		}
		//
		// for (int i = 0; i < H; i++) {
		// 	for (int j = 0; j < W; j++) {
		// 		System.out.print(map[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }

		int[][][] visited = new int[H][W][4];
		LinkedList<int[]> q = new LinkedList<>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				Arrays.fill(visited[i][j], Integer.MAX_VALUE);
			}
		}
		for (int i = 0; i < 4; i++) {
			visited[sx][sy][i] = -1;
		}
		q.add(new int[]{sx, sy, -1, 0});

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				if (nx < 0 || ny < 0 || nx >= H || ny >= W) {
					continue;
				}
				if (map[nx][ny] == '.') {
					if (cur[2] == -1) {
						q.add(new int[]{nx, ny, dir, cur[3]});
						visited[nx][ny][dir] = 0;
					} else if (cur[2] != dir && visited[nx][ny][dir] > cur[3] + 1) {
						visited[nx][ny][dir] = cur[3] + 1;
						q.add(new int[]{nx, ny, dir, cur[3] + 1});
					} else if (cur[2] == dir && visited[nx][ny][dir] > cur[3]) {
						visited[nx][ny][dir] = cur[3];
						q.add(new int[]{nx, ny, dir, cur[3]});
					}
				} else if (map[nx][ny] == 'C' && visited[nx][ny][dir] != -1) {
					if (cur[2] != dir && visited[nx][ny][dir] > cur[3] + 1) {
						visited[nx][ny][dir] = cur[3] + 1;
					} else if (cur[2] == dir && visited[nx][ny][dir] > cur[3]) {
						visited[nx][ny][dir] = cur[3];
					}
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			answer = Math.min(answer, visited[ex][ey][i]);
		}
		System.out.println(answer);
		// for (int i = 0; i < H; i++) {
		// 	for (int j = 0; j < W; j++) {
		// 		System.out.print(Arrays.toString(visited[i][j]) + " ");
		// 	}
		// 	System.out.println();
		// }
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