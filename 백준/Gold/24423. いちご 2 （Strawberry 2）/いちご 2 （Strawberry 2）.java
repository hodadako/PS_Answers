import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Node) {
				Node other = (Node) o;
				return this.x == other.x && this.y == other.y;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return (x + "," + y).hashCode();
		}
	}
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

	static int H, W, N;
	static HashMap<Node, Integer> countMap = new HashMap<>();
	static int answer = 0;

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		H = fr.nextInt();
		W = fr.nextInt();
		N = fr.nextInt();

		for (int i = 0; i < N; i++) {
			int a = fr.nextInt() - 1;
			int b = fr.nextInt() - 1;

			for (int x = -1; x <= 1; x++) {
				for (int y = -1; y <= 1; y++) {
					int nx = a + x;
					int ny = b + y;
					if (nx >= 1 && nx < H - 1 && ny >= 1 && ny < W - 1) {
						Node key = new Node(nx, ny);
						countMap.put(key, countMap.getOrDefault(key, 0) + 1);
						answer = Math.max(answer, countMap.get(key));
					}
				}
			}
		}

		System.out.println(answer);
	}
}
