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

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Node) {
				Node other = (Node)o;
				return x == other.x && y == other.y;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return (x + " ," + y).hashCode();
		}
	}

	static int N, K;
	static String order;
	static int xMax, yMax, countMax;
	static boolean containX;
	static HashSet<Integer> counter = new HashSet<>();

	public static void main(String[] args) {
		FastReader fr = new FastReader();

		N = fr.nextInt();
		order = fr.next();
		K = fr.nextInt();

		getMax();

		int result = 0;
		for (int i = 0; i < K; i++) {
			int a = fr.nextInt() - 1;
			int b = fr.nextInt() - 1;
			if (check(a, b)) {
				// System.out.println((a + 1) + " " + (b + 1));
				result++;
			}
		}

		System.out.println(result);
	}

	static void getMax() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			switch (order.charAt(i)) {
				case 'R':
					xMax++;
					break;
				case 'U':
					yMax++;
					break;
				case 'X':
					count++;
					countMax++;
					containX = true;
					counter.add(count);
					break;
			}
		}
	}

	static boolean check(int a, int b) {
		int min = Math.min(a, b);
		if (containX) {
			if (counter.contains(min)) {
				a -= min;
				b -= min;
			} else if (min > countMax) {
				a -= countMax;
				b -= countMax;
			}
		}

		return a <= xMax && b <= yMax;
	}
}