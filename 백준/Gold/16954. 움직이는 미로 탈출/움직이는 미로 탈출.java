import java.util.*;
import java.io.*;

public class Main {
	static int H = 8, W = 8;
	static char[][] map;
	static boolean[][] blocked, visited;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1, 0};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1, 0};
	static LinkedList<int[]> moves = new LinkedList<>();
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		map = new char[H][W];
		blocked = new boolean[H][W];
		visited = new boolean[H][W];
		moves.add(new int[] {7, 0});
		for (int i = 0; i < H; i++) {
			String s = fr.next();
			for (int j = 0; j < W; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '#') {
					blocked[i][j] = true;
				}
			}
		}

		while (!moves.isEmpty() && !visited[0][7]) {
			next();
			move();
		}

		System.out.println(visited[0][7] ? 1 : 0);
	}

	static void next() {
		LinkedList<int[]> q = new LinkedList<>();
		while (!moves.isEmpty()) {
			int[] cur = moves.poll();
			int x = cur[0], y = cur[1];
			if (blocked[x][y]) {
				continue;
			}
			for (int i = 0; i < 9; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= H || ny >= W) {
					continue;
				}
				if (map[nx][ny] == '.') {
					q.add(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
		moves.addAll(q);
	}

	static void move() {
		char[][] temp = new char[H][W];
		boolean[][] tempB = new boolean[H][W];
		for (int j = 0; j < W; j++) {
			temp[0][j] = '.';
		}
		for (int i = 0; i < H - 1; i++) {
			for (int j = 0; j < W; j++) {
				temp[i + 1][j] = map[i][j];
				if (map[i][j] == '#') {
					tempB[i + 1][j] = true;
				}
			}
		}
		map = temp;
		blocked = tempB;
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