import java.math.BigInteger;
import java.util.*;

public class Main {
	static int N;
	static BigInteger modular = new BigInteger("1000000007");
	static HashMap<BigInteger, BigInteger> map = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map.put(BigInteger.ZERO, BigInteger.ONE);
		map.put(BigInteger.ONE, BigInteger.ONE);

		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			if (a % 2 == 0) {
                a /= 2;
				BigInteger result = factorial(BigInteger.valueOf(2 * a))
					.divide(factorial(BigInteger.valueOf(a))
						.multiply(factorial(BigInteger.valueOf(a + 1))));
				System.out.println(result.mod(modular));
			} else {
				System.out.println(0);
			}
		}

	}

	private static BigInteger factorial(BigInteger n) {
		if (map.containsKey(n)) {
			return map.get(n);
		}

		BigInteger result = n.multiply(factorial(n.subtract(BigInteger.ONE)));

		map.put(n, result);
		return result;
	}
}
