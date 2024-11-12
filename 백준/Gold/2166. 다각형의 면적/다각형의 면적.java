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
	static Node[] coordinates;

	static class Node {
		double x, y;

		public Node(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		coordinates = new Node[N];

		for (int i = 0; i < N; i++) {
			coordinates[i] = new Node(fr.nextDouble(), fr.nextDouble());
		}

		double answer = 0;
		for (int i = 0; i < N; i++) {
			Node c1 = coordinates[i];
			Node c2 = coordinates[(i + 1) % N];
			answer += c1.x * c2.y - c2.x * c1.y;
		}

		answer = Math.abs(answer) / 2.0;
		System.out.println(String.format("%.1f", answer));
	}
}
