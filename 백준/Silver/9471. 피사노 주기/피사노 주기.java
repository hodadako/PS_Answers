import java.util.*;
import java.io.*;

public class Main {
	static int P;
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		P = fr.nextInt();
		for (int i = 0; i < P; i++) {
			int n = fr.nextInt();
			int m = fr.nextInt();
			int answer = 0;
			ArrayList<Long> list = new ArrayList<>();
			long a = 1;
			long b = 1;
			for (int j = 1; j < 1000001; j++) {
				long temp = (a + b) % m;
				a = b;
				b = temp;
				list.add(temp);
				if (list.size() >= 3) {
					if (list.get(j - 1) == list.get(1) && list.get(j - 2) == list.get(0)) {
						answer = list.size() - 2;
						break;
					}
				}
			}
			System.out.println(n + " " + answer);
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
	}
}