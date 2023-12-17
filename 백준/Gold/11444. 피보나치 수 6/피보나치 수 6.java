import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
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

	static BigInteger modular = new BigInteger("1000000007");
	static HashMap<BigInteger, BigInteger> map = new HashMap<>();

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		String n = fr.next();
		BigInteger target = new BigInteger(n);
		map.put(BigInteger.ONE, BigInteger.ONE);
		map.put(BigInteger.ZERO, BigInteger.ZERO);
		System.out.println(fibonacci(target));
	}

	private static BigInteger fibonacci(BigInteger n) {
		if (map.containsKey(n)) {
			return map.get(n);
		}
		BigInteger result;
		if ((n.mod(BigInteger.TWO)).equals(BigInteger.ZERO)) {
			BigInteger half = n.divide(BigInteger.TWO);
			BigInteger fibonacci = fibonacci(half);
			BigInteger fibonacciSubtractOne = fibonacci(half.subtract(BigInteger.ONE));
			result = fibonacciSubtractOne.multiply(BigInteger.TWO)
				.add(fibonacci)
				.multiply(fibonacci)
				.mod(modular);
		} else {
			BigInteger half = n.add(BigInteger.ONE).divide(BigInteger.TWO);
			BigInteger fibonacci = fibonacci(half);
			BigInteger fibonacciSubtractOne = fibonacci(half.subtract(BigInteger.ONE));
			result = fibonacci.pow(2).add(fibonacciSubtractOne.pow(2)).mod(modular);
		}

		map.put(n, result);  // Memoization
		return result;
	}
}