import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o1.value, o2.value));
	static double[][] stars = new double[101][2];
	static int[] parent = new int[101];
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			stars[i][0] = sc.nextDouble();
			stars[i][1] = sc.nextDouble();
			parent[i] = i;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) {
					pq.add(new Node(i, j, getDistance(i, j)));
				}
			}
		}
		double answer = 0;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (isCycle(cur.end, cur.start)) {
				continue;
			}
			union(cur.start, cur.end);
			answer += cur.value;
			// System.out.println("cur.value = " + cur.value);
		}
		System.out.printf("%.2f\n", answer);
	}

	static int getParent(int i) {
		if (i != parent[i]) {
			parent[i] = getParent(parent[i]);
		}
		return parent[i];
	}

	static void union(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if (a != b) {
			parent[b] = a;
		}
	}

	static boolean isCycle(int i, int j) {
		return getParent(i) == getParent(j);
	}

	static double getDistance(int i, int j) {
		double a = Math.abs(stars[i][0] - stars[j][0]);
		double b = Math.abs(stars[i][1] - stars[j][1]);
		double result = Math.sqrt(a * a + b * b);
		return result;
	}

	static class Node {
		int start, end;
		double value;

		public Node(int start, int end, double value) {
			this.start = start;
			this.end = end;
			this.value = value;
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

	    double nextDouble() {
	        return Double.parseDouble(next());
	    }

	    long nextLong() {
	        return Long.parseLong(next());
	    }
	}
}
