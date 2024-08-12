import java.io.*;
import java.util.*;

class Main {
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();

		}

		public Integer nextInt() {
			return Integer.parseInt(next());
		}
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		List<Integer> list = new ArrayList<>();
		boolean flag = false;

		for (int i = 0; i < 9; i++) {
			list.add(fr.nextInt());
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (i != j) {
					int sum = 0;
					List<Integer> now = new ArrayList<>();
					for (int k = 0; k < 9; k++) {
						if (k != i && k != j) {
							sum += list.get(k);
							now.add(list.get(k));
						}
					}

					if (sum == 100) {
						Collections.sort(now);
						for (int l = 0; l < 7; l++) {
							System.out.println(now.get(l));
						}
						flag = true;
						break;
					}
				}

				if (flag) {
					break;
				}
			}
			if (flag) {
				break;
			}
		}
	}
}