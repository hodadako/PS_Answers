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
			long a = 1;
			long b = 1;
			for (int j = 2; j <= Integer.MAX_VALUE; j++) {
				long temp = (a + b) % m;
				a = b;
				b = temp;
				if (a == 1 && b == 1) {
					answer = j - 1;
					break;
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