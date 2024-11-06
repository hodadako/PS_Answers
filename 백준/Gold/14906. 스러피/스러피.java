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
	static String[] arr;

	public static void main(String[] args) {
		FastReader fr = new FastReader();

		N = fr.nextInt();
		arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = fr.next();
		}

		printAnswer();
	}

	static void printAnswer() {
		System.out.println("SLURPYS OUTPUT");
		for (int i = 0; i < N; i++) {
			System.out.println(solve(arr[i]));
		}
		System.out.println("END OF OUTPUT");
	}

	static String solve(String s) {
		String[] strArr = new String[0];
		if (s.contains("C")) {
			int index = s.lastIndexOf("C");
			strArr = new String[2];
			strArr[0] = s.substring(0, index + 1);
			strArr[1] = s.substring(index + 1);
		} else if (s.contains("H")) {
			int index = s.lastIndexOf("H");
			strArr = new String[2];
			strArr[0] = s.substring(0, index + 1);
			strArr[1] = s.substring(index + 1);
		}

		// System.out.println(Arrays.toString(strArr));
		if (strArr.length < 2) {
			return "NO";
		}
		
		if (strArr[0].length() == 0 || strArr[1].length() == 0) {
			return "NO";
		}

		return isSlimp(strArr[0]) && isSlump(strArr[1]) ? "YES" : "NO";
	}

	static boolean isSlump(String s) {
		if (s.length() < 3) {
			return false;
		}

		if (!(s.startsWith("D") || s.startsWith("E"))) {
			return false;
		}

		if (!s.endsWith("G")) {
			return false;
		}

		if (s.charAt(1) != 'F') {
			return false;
		}

		if (s.charAt(2) != 'G') {
			if (s.length() == 3) {
				return false;
			} else if (s.length() > 3){
				for (int i = 2; i < s.length(); i++) {
					if (s.charAt(i) == 'E' || s.charAt(i) == 'D') {
						return isSlump(s.substring(i));
					}
				}
			}
		}

		return true;
	}

	static boolean isSlimp(String s) {
		if (!s.startsWith("A") || s.length() < 2) {
			return false;
		}

		if (s.length() == 2 && !s.endsWith("H")) {
			return false;
		}

		if (s.length() > 2) {
			if (!s.endsWith("C")) {
				return false;
			}
			if (s.startsWith("A")) {
				if (s.charAt(1) == 'B') {
					return isSlimp(s.substring(2, s.length() - 1));
				} else {
					return isSlump(s.substring(1, s.length() - 1));
				}
			}
			return false;
		}
		return true;
	}
}