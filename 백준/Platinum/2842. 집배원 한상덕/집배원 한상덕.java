import java.io.*;
import java.util.*;

public class Main {
	static int N, sx, sy, totalHouse, answer = Integer.MAX_VALUE;
	static char[][] map;
	static boolean[][] visited;
	static int[][] height;
	static List<Integer> heights = new ArrayList<>();
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		map = new char[N][N];
		height = new int[N][N];
		totalHouse = 0;

		TreeSet<Integer> heightSet = new TreeSet<>();

		for (int i = 0; i < N; i++) {
			String s = fr.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'P') {
					sx = i;
					sy = j;
				} else if (map[i][j] == 'K') {
					totalHouse++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				height[i][j] = fr.nextInt();
				heightSet.add(height[i][j]);
			}
		}

		heights.addAll(heightSet);

		int s = 0, e = 0;
		while (e < heights.size() && s < heights.size()) {
			if (bfs(heights.get(s), heights.get(e))) {
				answer = Math.min(answer, heights.get(e) - heights.get(s));
				s++;
			} else {
				e++;
			}
		}

		System.out.println(answer);
	}

	private static boolean bfs(int minHeight, int maxHeight) {
		if (height[sx][sy] < minHeight || height[sx][sy] > maxHeight) {
			return false;
		}

		visited = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{sx, sy});
		visited[sx][sy] = true;
		int count = 0;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0], y = cur[1];

			if (map[x][y] == 'K') {
				count++;
			}

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i], ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;
				if (height[nx][ny] < minHeight || height[nx][ny] > maxHeight) continue;

				visited[nx][ny] = true;
				q.add(new int[]{nx, ny});
			}
		}
		return count == totalHouse;
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
