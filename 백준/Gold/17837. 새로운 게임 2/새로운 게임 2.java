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

	static class Node {
		int x, y, dir, num;

		public Node(int x, int y, int dir, int num) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.num = num;
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Node) {
				Node n = (Node) o;
				return n.num == this.num;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return (num + ", ").hashCode();
		}

		@Override
		public String toString() {
			return "(" + x + ", " + y + ", " + dir + ", " + num + ")";
		}
	}

	static int N, K, count;
	static boolean end = false;
	static int[][] board;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static HashMap<Integer, Node> map = new HashMap<>();
	static ArrayList<Node>[][] nodes;

	static int blue(int currentDir) {
		if (currentDir == 0) {
			return 1;
		} else if (currentDir == 1) {
			return 0;
		} else if (currentDir == 2) {
			return 3;
		}
		return 2;
	}

	static boolean checkWhite(int x, int y) {
		return board[x][y] == 0;
	}

	static boolean checkRed(int x, int y) {
		return board[x][y] == 1;
	}

	static boolean checkBlue(int x, int y) {
		return board[x][y] == 2;
	}

	static void printBoard(ArrayList<Node>[][] board) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("__________________________");
	}

	static void move(Node now) {
		int index = nodes[now.x][now.y].indexOf(now);
		int nx = now.x + dx[now.dir];
		int ny = now.y + dy[now.dir];
		boolean checked = false;
		ArrayList<Node> temp = new ArrayList<>();

		if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
			int newDir = blue(now.dir);
			nx = now.x + dx[newDir];
			ny = now.y + dy[newDir];
			now.dir = newDir;
			checked = true;
		}

		if (checkBlue(nx, ny)) {
			if (!checked) {
				int newDir = blue(now.dir);
				nx = now.x + dx[newDir];
				ny = now.y + dy[newDir];
				now.dir = newDir;
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					return;
				}
				if (checkWhite(nx, ny)) {
					temp.add(new Node(nx, ny, now.dir, now.num));
					for (int j = index + 1; j < nodes[now.x][now.y].size(); j++) {
						Node node = nodes[now.x][now.y].get(j);
						temp.add(new Node(nx, ny, node.dir, node.num));
					}
				} else if (checkRed(nx, ny)) {
					temp.add(new Node(nx, ny, now.dir, now.num));
					for (int j = index + 1; j < nodes[now.x][now.y].size(); j++) {
						Node node = nodes[now.x][now.y].get(j);
						temp.add(new Node(nx, ny, node.dir, node.num));
					}
				} 
			}
		} else if (checkWhite(nx, ny)) {
			temp.add(new Node(nx, ny, now.dir, now.num));
			for (int j = index + 1; j < nodes[now.x][now.y].size(); j++) {
				Node node = nodes[now.x][now.y].get(j);
				temp.add(new Node(nx, ny, node.dir, node.num));
			}
		} else if (checkRed(nx, ny)) {
			temp.add(new Node(nx, ny, now.dir, now.num));
			for (int j = index + 1; j < nodes[now.x][now.y].size(); j++) {
				Node node = nodes[now.x][now.y].get(j);
				temp.add(new Node(nx, ny, node.dir, node.num));
			}
		}

		// System.out.println("temp = " + temp);
		// System.out.println("nodes[now.x][now.y] = " + nodes[now.x][now.y]);
		// System.out.println("index = " + index);
		ArrayList<Node> original = new ArrayList<>();
		for (int j = 0; j < nodes[now.x][now.y].size(); j++) {
			Node node = nodes[now.x][now.y].get(j);
			if (!temp.contains(node)) {
				original.add(node);
			}
		}

		if (checkRed(nx, ny)) {
			Collections.reverse(temp);
		}


		for (Node n : temp) {
			nodes[nx][ny].add(n);
			map.put(n.num, n);
		}

		if (nodes[nx][ny].size() >= 4) {
			end = true;
		}
		nodes[now.x][now.y] = original;
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		K = fr.nextInt();
		board = new int[N][N];
		nodes = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = fr.nextInt();
				nodes[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < K; i++) {
			int x = fr.nextInt() - 1;
			int y = fr.nextInt() - 1;
			Node now = new Node(x, y, fr.nextInt() - 1, i);
			map.put(i, now);
			nodes[x][y].add(now);
		}

		while (count++ < 1001) {
			for (int i = 0; i < K; i++) {
				move(map.get(i));
				// printBoard(nodes);
			}

			if (end) {
				break;
			}
		}

		System.out.println(count >= 1001 ? -1 : count);
	}
}
