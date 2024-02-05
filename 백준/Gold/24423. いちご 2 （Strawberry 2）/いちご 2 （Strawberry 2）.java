import java.io.*;
import java.util.*;

class Main {
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

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Node node = (Node)o;
			return x == node.x && y == node.y;
		}

		@Override
		public int hashCode() {
			return (x + "," + y).hashCode();
		}
	}

	static int H, W, N;
	static HashSet<Node> nodes = new HashSet<>();
	static int[][] graph;
	static int answer = 0;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		H = fr.nextInt();
		W = fr.nextInt();
		N = fr.nextInt();

		graph = new int[H][W];

		for (int i = 0; i < N; i++) {
			int a = fr.nextInt() - 1;
			int b = fr.nextInt() - 1;

			graph[a][b]++;
			nodes.add(new Node(a, b));
		}

		for (Node node : nodes) {
			count(node);
		}

		System.out.println(answer);
	}

	private static void count(Node node) {
		int result = 0;
		ArrayList<Node> nodeArrayList = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			int nx = node.x + dx[i];
			int ny = node.y + dy[i];

			if (nx < 0 || nx >= H || ny < 0 || ny >= W) {
				continue;
			}
			result += graph[nx][ny];
			nodeArrayList.add(new Node(nx, ny));
		}
		result += graph[node.x][node.y];
		answer = Math.max(answer, result);

		for (Node now : nodeArrayList) {
			int nowResult = 0;
			for (int i = 0; i < 8; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx < 0 || nx >= H || ny < 0 || ny >= W) {
					continue;
				}
				nowResult += graph[nx][ny];
			}
			nowResult += graph[now.x][now.y];
			answer = Math.max(answer, nowResult);
		}
	}
}