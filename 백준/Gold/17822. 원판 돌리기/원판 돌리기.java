import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
	static int N, M, T;
	static int[][] disks;
	static boolean[][] visited;
	static boolean NONE = true;
	static int[] dx = {0, 1, 0, -1, 0};
	static int[] dy = {1, 0, -1, 0, 1};

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		M = fr.nextInt();
		T = fr.nextInt();

		disks = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				disks[i][j] = fr.nextInt();
			}
		}

		for (int i = 0; i < T; i++) {
			NONE = true;
			visited = new boolean[N][M];
			int x = fr.nextInt();
			int d = fr.nextInt();
			int k = fr.nextInt();

			for (int j = 0; j < N; j++) {
				if ((j + 1) % x == 0) {
					if (d == 0) {
						for (int l = 0; l < k; l++) {
							turnClockwise(j);
							// print();
						}
					} else if (d == 1) {
						for (int l = 0; l < k; l++) {
							turnAnticlockwise(j);
							// print();
						}
					}
				}
			}
			int total = 0;
			double count = 0;

			for (int j = 0; j < N; j++) {
				for (int l = 0; l < M; l++) {
					if (disks[j][l] != 0) {
						total += disks[j][l];
						count++;
						dfs(j, l);
						// if (disks[j][l] == 0) {
						// 	System.out.println("j = " + j);
						// 	System.out.println("l = " + l);
						// 	print();
						// }
					}
				}
			}

			if (NONE) {
				double avg = total / count;
				for (int j = 0; j < N; j++) {
					for (int l = 0; l < M; l++) {
						if (disks[j][l] > avg) {
							disks[j][l]--;
						} else if (disks[j][l] < avg && disks[j][l] != 0) {
							disks[j][l]++;
						}
					}
				}
			}

			// print();
		}

		System.out.println(Arrays.stream(disks).flatMapToInt(Arrays::stream).sum());
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(disks[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("_____________________");
	}

	public static void turnClockwise(int i) {
		int first = disks[i][M - 1];
		for (int j = M - 2; j >= 0; j--) {
			disks[i][j + 1] = disks[i][j];
		}

		disks[i][0] = first;
	}

	public static void turnAnticlockwise(int i) {
		int last = disks[i][0];
		for (int j = 0; j < M - 1; j++) {
			disks[i][j] = disks[i][j + 1];
		}

		disks[i][M - 1] = last;
	}

	public static void dfs(int a, int b) {
		LinkedList<Node> q = new LinkedList<>();
		ArrayList<Node> nodes = new ArrayList<>();
		q.add(new Node(a, b));
		nodes.add(new Node(a, b));
		visited[a][b] = true;
		int now = disks[a][b];
		boolean check = false;

		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.x == 0) {
				for (int i = 0; i < 3; i++) {
					int nx = node.x + dx[i];
					int ny = node.y + dy[i];
					if (ny < 0) {
						ny = M - 1;
					} else if (ny >= M) {
						ny = 0;
					}
					if (now == disks[nx][ny] && !visited[nx][ny]) {
						check = true;
						q.add(new Node(nx, ny));
						nodes.add(new Node(nx, ny));
						visited[nx][ny] = true;
					}
				}
			} else if (node.x > 0 && node.x < N - 1) {
				for (int i = 0; i < 4; i++) {
					int nx = node.x + dx[i];
					int ny = node.y + dy[i];
					if (ny < 0) {
						ny = M - 1;
					} else if (ny >= M) {
						ny = 0;
					}
					if (now == disks[nx][ny] && !visited[nx][ny]) {
						check = true;
						q.add(new Node(nx, ny));
						nodes.add(new Node(nx, ny));
						visited[nx][ny] = true;
					}
				}
			} else {
				for (int i = 2; i < 5; i++) {
					int nx = node.x + dx[i];
					int ny = node.y + dy[i];
					if (ny < 0) {
						ny = M - 1;
					} else if (ny >= M) {
						ny = 0;
					}
					if (now == disks[nx][ny] && !visited[nx][ny]) {
						check = true;
						q.add(new Node(nx, ny));
						nodes.add(new Node(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}
		}

		if (check) {
			for (Node node : nodes) {
				disks[node.x][node.y] = 0;
			}
			NONE = false;
		}
	}

	private static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
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
	}
}