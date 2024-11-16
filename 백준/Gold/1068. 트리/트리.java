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
	static int[] parent;
	static int target, answer, root;

	public static void main(String[] args) {
		FastReader sc = new FastReader();

		N = sc.nextInt();
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = sc.nextInt();
			if (parent[i] == -1) {
				root = i;
			}
		}
		target = sc.nextInt();
		delete(target);

		for (int i = 0; i < N; i++) {
			isLeaf(i);
		}

		// System.out.println(Arrays.toString(parent));
		System.out.println(answer);
	}

	static void delete(int target) {
		boolean found = false;
		for (int i = 0; i < N; i++) {
			if (parent[i] == target) {
				parent[i] = -2;
				delete(i);
				found = true;
			} else if (i == target) {
				parent[i] = -2;
			}
		}

		if (!found) {
			return;
		}
	}

	static void isLeaf(int target) {
		if (parent[target] == -2) {
			return;
		}

		if (parent[target] == -1) {
			boolean isLeaf = true;
			for (int i = 0; i < N; i++) {
				if (i != target && parent[i] == root) {
					isLeaf = false;
				}
			}
			if (isLeaf) {
				answer++;
				return;
			} else {
				return;
			} 
		}

		for (int i = 0; i < N; i++) {
			if (parent[i] == target) {
				return;
			}
		}
		answer++;
	}
}