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
	}

	static int TC;
	static char[][] map;
	static char[][] control;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static HashSet<Character> keys = new HashSet<>();

	// 0. 현재 가지고 올 수 있는 문서를 찾자.
	// 1. 현재 취득할 수 있는 키를 찾자.
	// 1-1. 키가 하나도 없다면 멈춰!
	// 2. 열 수 있는 문을 찾자.
	// 2-1. 열 수 있는 문이 하나도 없다면 멈춰!
	// 2. 문을 열고 문을 연 좌표에서 부터 다시 반복.

	static boolean isKey(char c) {
		return Character.isLowerCase(c);
	}

	static boolean isDoor(char c) {
		return Character.isUpperCase(c);
	}

	static boolean isDocument(char c) {
		return c == '$';
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static boolean isCycle(int h, int w) {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (map[i][j] != control[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	static void copy(int h, int w) {
		control = new char[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				control[i][j] = map[i][j];
			}
		}
	}

	static int bfs(int h, int w) {
		visited = new boolean[h][w];
		visited[0][0] = true;
		int docs = 0;
		LinkedList<Node> q = new LinkedList<>();
		q.add(new Node(0, 0));
		while (!q.isEmpty()) {
			Node now = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= h || ny >= w || visited[nx][ny] || map[nx][ny] == '*') {
					continue;
				}

				if (map[nx][ny] == '.') {
					visited[nx][ny] = true;
					q.add(new Node(nx, ny));
				} else if (isDoor(map[nx][ny])) {
					if (keys.contains(Character.toLowerCase(map[nx][ny]))) {
						visited[nx][ny] = true;
						q.add(new Node(nx, ny));
						map[nx][ny] = '.';
					}
				} else if (isKey(map[nx][ny])) {
					keys.add(map[nx][ny]);
					map[nx][ny] = '.';
					visited[nx][ny] = true;
					q.add(new Node(nx, ny));
				} else if (isDocument(map[nx][ny])) {
					docs++;
					map[nx][ny] = '.';
					visited[nx][ny] = true;
					q.add(new Node(nx, ny));
				}
			}
		}
		return docs;
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		TC = fr.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < TC; i++) {
			int h = fr.nextInt();
			int w = fr.nextInt();
			map = new char[h + 2][w + 2];
			for (int j = 0; j < h + 2; j++) {
				Arrays.fill(map[j], '.');
			}

			for (int j = 0; j < h; j++) {
				String line = fr.next();
				for (int k = 0; k < w; k++) {
					map[j + 1][k + 1] = line.charAt(k);
				}
			}

			String key = fr.next();
			for (int j = 0; j < key.length(); j++) {
				if (Character.isDigit(key.charAt(j))) {
					continue;
				}
				keys.add(key.charAt(j));
			}

			int answer = 0;

			// System.out.println("keys = " + keys);
			while (true) {

				int result = bfs(h + 2, w + 2);
				if (result == 0 && keys.isEmpty()) {
					break;
				} else {
					answer += result;
				}
				if (control != null) {
					if (isCycle(h + 2, w + 2)) {
						// System.out.println("이거 되냐???");
						break;
					}
				}

				copy(h + 2, w + 2);
				
				// print(h, w);
				// printControl(h, w);
				// System.out.println("keys = " + keys);
			}

			sb.append(answer + "\n");
			// print(h, w);
			control = null;
			keys.clear();
		}

		System.out.println(sb);
	}

	static void print(int h, int w) {
		System.out.println("____________________________________");

		for (int i = 0; i < h + 2; i++) {
			for (int j = 0; j < w + 2; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("____________________________________");
	}
	static void printControl(int h, int w) {
		System.out.println("_____CONTROL_________________");

		for (int i = 0; i < h + 2; i++) {
			for (int j = 0; j < w + 2; j++) {
				System.out.print(control[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("____________________________________");
	}
}
