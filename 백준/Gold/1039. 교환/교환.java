import java.io.*;
import java.util.*;

public class Main {
	static int N, K, answer = -1;

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		K = fr.nextInt();
		bfs(N, K);
		System.out.println(answer);
	}

	static void bfs(int N, int K) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int len = String.valueOf(N).length();
		int check = 1;
		for (int i = 1; i <= len; i++) {
			check *= 10;
		}
		check /= 10;
		q.add(new int[]{K, N});

		// System.out.println(check);
		// System.out.println(q);
		boolean[][] visited = new boolean[1000001][K + 1];
		while (!q.isEmpty()) {
			int[] cur = q.removeFirst();
			for (int i = 1; i <= len; i++) {
				for (int j = 1; j <= len; j++) {
					if (i == j) continue;
					int result = changeNumber(i, j, cur[1], check);
					// System.out.println("result = " + result);
					if (result == -1) continue;
					if (visited[result][cur[0] - 1]) continue;
					if (cur[0] - 1 == 0) {
						answer = Math.max(answer, result);
					} else if (cur[0] - 1 > 0) {
						q.add(new int[]{cur[0] - 1, result});
						visited[result][cur[0] - 1] = true;
					}
				}
			}
		}
	}

	static int changeNumber(int i, int j, int target, int check) {
		int mod1 = 10;
		int fl1 = 1;
		int mod2 = 10;
		int fl2 = 1;
		for (int k = 0; k < i - 1; k++) {
			mod1 *= 10;
			fl1 *= 10;
		}
		for (int k = 0; k < j - 1; k++) {
			mod2 *= 10;
			fl2 *= 10;
		}

		// System.out.println(mod1 + " " + fl1 + " " + mod2 + " " + fl2);

		int a = target % mod1 - target % fl1;
		int b = target % mod2 - target % fl2;

		while (a >= 10) {
			a /= 10;
		}
		while (b >= 10) {
			b /= 10;
		}
		//
		// System.out.println("a = " + a);
		// System.out.println("b = " + b);
		int newTarget = target;
		newTarget -= a * fl1;
		newTarget -= b * fl2;
		newTarget += a * fl2;
		newTarget += b * fl1;
		if (newTarget < check) {
			return -1;
		}

		return newTarget;
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