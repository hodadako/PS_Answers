import java.util.*;
import java.io.*;

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

	    long nextLong() {
	        return Long.parseLong(next());
	    }

	    double nextDouble() {
	        return Double.parseDouble(next());
	    }
	}

	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		LinkedList<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		while (!q.isEmpty()) {
			Integer poll = q.poll();
			sb.append(poll + " ");

			if (!q.isEmpty()) {
				q.offer(q.poll());
			}
		}

		System.out.println(sb.toString());
	}
}