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
	}

	static int[] stacks;
	static int N;
	static long answer;

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();

		stacks = new int[N];

		for (int i = 0; i < N; i++) {
			stacks[i] = sc.nextInt();
		}

		for (int i = 0; i < N - 1; i++) {
			int now = stacks[i];
			long count = 0;

			for (int j = i + 1; j < N; j++) {
				if (now > stacks[j]) {
					count++;
				} else {
					break;
				}
			}

			answer += count;
		}

		System.out.println(answer);
	}
}
