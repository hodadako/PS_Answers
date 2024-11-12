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

	static int N;
	static String orders;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	// 수가 커질 수록 좌회전
	static char[][] answer;
	static int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
	static ArrayList<Node> nodes = new ArrayList<>();
	static int H, W;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node{" +
				   "x=" + x +
				   ", y=" + y +
				   '}';
		}

		@Override
		public final boolean equals(Object o) {
			if (o instanceof Node) {
				Node n = (Node)o;
				return x == n.x && y == n.y;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return (x + ", " + y).hashCode();
		}
	}

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		orders = sc.next();

		bfs(0, 0);
		// System.out.println(nodes);
		buildAnswer();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(answer[i][j]);
			}
			System.out.println();
		}
	}

	private static void buildAnswer() {
		H = maxX - minX + 1;
		W = maxY - minY + 1;
		// System.out.println(maxX + " " + minX + " " + maxY + " " + minY);
		// System.out.println(H + " " + W);
		answer = new char[H][W];
		for (int i = 0; i < H; i++) {
			Arrays.fill(answer[i], '#');
		}
		for (Node n : nodes) {
			int nx = n.x - minX;
			int ny = n.y - minY;
			// System.out.println(nx + " " + ny);
			answer[nx][ny] = '.';
		}
	}

	private static void bfs(int i, int j) {
		nodes.add(new Node(i, j));
		maxX = Math.max(maxX, i);
		maxY = Math.max(maxY, j);
		minX = Math.min(minX, i);
		minY = Math.min(minY, j);

		int curDir = 0;
		for (int k = 0; k < orders.length(); k++) {
			if (orders.charAt(k) == 'L') {
				curDir = (curDir + 1) % 4;
			} else if (orders.charAt(k) == 'R') {
				curDir = curDir - 1;
				if (curDir == -1) {
					curDir = 3;
				}
			} else {
				i += dx[curDir];
				j += dy[curDir];
				maxX = Math.max(maxX, i);
				maxY = Math.max(maxY, j);
				minX = Math.min(minX, i);
				minY = Math.min(minY, j);
				nodes.add(new Node(i, j));
			}
		}
	}
}