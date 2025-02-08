import java.io.*;
import java.util.*;

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

		long nextLong() {
			return Long.parseLong(next());
		}
	}

	static final int INF = (int) 1e9;

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		long N = fr.nextLong();
		ArrayList<Long> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(fr.nextLong());
		}

		Collections.sort(list);

		if (N == 3) {
			System.out.println(list.get(0) + " " + list.get(1) + " " + list.get(2));
			return;
		}

		int alkali = INF;
		int acid = INF;

		for (int i = 0; i < N; i++) {
			if (list.get(i) < 0) {
				alkali = i;
			}

			if (list.get(i) > 0) {
				acid = i;
				break;
			}
		}

		if (alkali != INF && acid == INF) {
			System.out.println(list.get(alkali - 2) + " " + list.get(alkali - 1) + " " + list.get(alkali));
		} else if (alkali == INF && acid != INF) {
			System.out.println(list.get(acid) + " " + list.get(acid + 1) + " " + list.get(acid + 2));
		} else {
			long[] result = new long[3];
			long closestSum = Long.MAX_VALUE;
			for (int i = 1; i < (int)N - 1; i++) {
				int low = 0;
				int high = (int)N - 1;

				while (low < i && i < high) {
					long curSum = list.get(i) + list.get(low) + list.get(high);
					if (Math.abs(curSum) < Math.abs(closestSum)) {
						closestSum = curSum;
						result[0] = list.get(low);
						result[1] = list.get(i);
						result[2] = list.get(high);
					}

					if (curSum == 0) {
						System.out.println(result[0] + " " + result[1] + " " + result[2]);
						return;
					} else if (curSum < 0) {
						low += 1;
					} else {
						high -= 1;
					}
				}
			}

			System.out.println(result[0] + " " + result[1] + " " + result[2]);
		}
	}
}
