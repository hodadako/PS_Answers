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

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int n = fr.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
		for (int i = 0; i < n; i++) {
			int now = fr.nextInt();
			if (now == 0) {
				if (pq.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(pq.poll());
				}
			} else {
				for (int j = 0; j < now; j++) {
					int present = fr.nextInt();
					pq.offer(present);
				}
			}
		}
	}
}