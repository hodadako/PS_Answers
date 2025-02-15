import java.util.*;
import java.io.*;

public class Main {
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

	static int N, M, answer = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static ArrayList<Cheese> cheeseBox = new ArrayList<>();

	static class Cheese {
		int x, y;

		public Cheese(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void bfs() {
		visited = new boolean[N][M];
		LinkedList<Cheese> q = new LinkedList<>();
		visited[0][0] = true;
		q.add(new Cheese(0, 0));
		while (!q.isEmpty()) {
			Cheese now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) {
					continue;
				}

				if (map[nx][ny] == 0) {
					visited[nx][ny] = true;
					q.add(new Cheese(nx, ny));
				}
			}
		}
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("__________________________");
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		M = fr.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int now = fr.nextInt();
				map[i][j] = now;
				if (now == 1) {
					cheeseBox.add(new Cheese(i, j));
				}
			}
		}

		while (!cheeseBox.isEmpty()) {
			ArrayList<Cheese> temp = new ArrayList<>();
			bfs();
			for (Cheese cheese : cheeseBox) {
				int count = 0;
				for (int i = 0; i < 4; i++) {
					int nx = cheese.x + dx[i];
					int ny = cheese.y + dy[i];
					if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
						continue;
					}
					if (map[nx][ny] == 0 && visited[nx][ny]) {
						count++;
					}
				}

				if (count >= 2) {
					map[cheese.x][cheese.y] = 0;
				} else {
					temp.add(cheese);
				}
			}
			answer++;
			cheeseBox = temp;
		}

		System.out.println(answer);
	}
}