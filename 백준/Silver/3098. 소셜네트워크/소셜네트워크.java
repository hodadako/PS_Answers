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

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}
	}

	static int N, M;
	static int[][] isFriend;
	static int[][] map;
	static boolean[][] visited;
	static TreeMap<Integer, Integer> answer = new TreeMap<>();

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];
		isFriend = new int[N + 1][N + 1];

		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(map[i], -1);
			Arrays.fill(isFriend[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			isFriend[a][b] = 1;
			isFriend[b][a] = 1;
			map[a][b] = 0;
			map[b][a] = 0;
		}

		for (int i = 0; i < N + 1; i++) {
			map[i][i] = -2;
			isFriend[i][i] = 1;
		}

		int count = 1;
		while (!isFinished()) {
			// int[][] copyMap = new int[N + 1][N + 1];
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					if (i == j) {
						continue;
					} else if (isFriend[i][j] < count + 1) {
						for (int k = 1; k < N + 1; k++) {
							if (k != i && k != j) {
								if (map[i][k] == -1 && isFriend[j][k] < count + 1) {
									map[i][k] = count;
									map[k][i] = count;
									isFriend[i][k] = count + 1;
									isFriend[k][i] = count + 1;
								}
							}
						}
					}
				}
			}
			count++;
			// print(map);
			// print(isFriend);
		}

		// print(map);
		getAnswer();

		System.out.println(answer.size());
		for (int key : answer.keySet()) {
			System.out.println(answer.get(key));
		}
		// print(isFriend);
	}

	private static void print(int[][] arr) {
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("_______________");
	}

	static boolean isFinished() {
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (map[i][j] == -1) {
					return false;
				}
			}
		}
		return true;
	}

	static void getAnswer() {
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (map[i][j] >= 1 && !visited[i][j]) {
					visited[i][j] = true;
					visited[j][i] = true;
					answer.put(map[i][j], answer.getOrDefault(map[i][j], 0) + 1);
				}
			}
		}
	}
}