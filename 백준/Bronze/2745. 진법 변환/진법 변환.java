
import java.io.*;
import java.util.*;

class Main {
	static HashMap<Character, Integer> changes = new HashMap<>();

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		String s = fr.next();
		int base = fr.nextInt();

		int result = 0;
		String p = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		for (int i = 0; i < 26; i++) {
			changes.put(p.charAt(i), i + 10);
		}

		for (int i = s.length() - 1; i >= 0; i--) {
			int now = 1;
			for (int j = 0; j < s.length() - i - 1; j++) {
				now *= base;
			}
			if (changes.containsKey(s.charAt(i))) {
				result += now * changes.get(s.charAt(i));
			} else {
				result += now * (Character.getNumericValue(s.charAt(i)));
			}
		}

		System.out.println(result);
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