import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
	static BigInteger n;
	static BigInteger mod = BigInteger.valueOf(1_500_000);
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		n = fr.nextBigInteger();
		long a = 0;
		long b = 1;
		long answer = 1;
		for (long i = 2; i <= n.mod(mod).longValue(); i++) {
			long temp = (a + b) % (long) 1e6;
			a = b;
			b = temp;
			answer = temp;
		}
		System.out.println(answer);
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

	    BigInteger nextBigInteger() {
			return new BigInteger(next());
		}
	}
}