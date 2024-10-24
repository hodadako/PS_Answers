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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}

	static int N, M;
	static int[] trains;
	static ArrayList<Integer> passageners = new ArrayList<>();
	static HashSet<Integer> set = new HashSet<>();

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		M = fr.nextInt();

		trains = new int[N + 1];

		init();

		// System.out.println(passageners);

		for (int i = 0; i < M; i++) {
			int operation = fr.nextInt();
			if (operation <= 2) {
				int trainNo = fr.nextInt();
				int seatNo = fr.nextInt();
				solve(operation, trainNo, seatNo);
			} else {
				int trainNo = fr.nextInt();
				solve(operation, trainNo);
			}
			// System.out.println("now = " + Arrays.toString(trains));
		}

		for (int i = 1; i < N + 1; i++) {
			set.add(trains[i]);
		}

		System.out.println(set.size());
	}

	private static void init() {
		int now = 1;
		passageners.add(now);
		for (int i = 0; i < 21; i++) {
			now = now << 1;
			passageners.add(now);
		}
	}

	private static void solve(int oper, int trainNo) {
		if (oper == 3) {
			trains[trainNo] = trains[trainNo] << 1;
			if (trains[trainNo] >= passageners.get(21)) {
				trains[trainNo] = trains[trainNo] - passageners.get(21);
			}
		} else if (oper == 4) {
			trains[trainNo] = trains[trainNo] >> 1;
			if (trains[trainNo] % 2 != 0) {
				trains[trainNo] = trains[trainNo] - 1;
			}
		}
	}

	private static void solve(int oper, int trainNo, int seatNo) {
		if (oper == 1) {
			// System.out.println(passageners.get(seatNo));
			trains[trainNo] = trains[trainNo] | passageners.get(seatNo);
		} else if (oper == 2) {
			trains[trainNo] = trains[trainNo] & ~passageners.get(seatNo);
		}
	}
}
