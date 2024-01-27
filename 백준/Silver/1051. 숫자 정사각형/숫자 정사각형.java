import java.util.*;
import java.io.*;

class Main {
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

	    long nextLong() {
	        return Long.parseLong(next());
	    }

	    double nextDouble() {
	        return Double.parseDouble(next());
	    }
	}

	static int N, M, answer = 1;
	static int[][] map;

	static int[] dx = {0, 1, 1};
	static int[] dy = {1, 0, 1};

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		M = fr.nextInt();
		int maxLen = Math.min(N, M);
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String now = fr.next();
			for (int j = 0; j < now.length(); j++) {
				int num = Character.getNumericValue(now.charAt(j));
				map[i][j] = num;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				check(maxLen, i, j);
			}
		}
		System.out.println(answer);
	}

	private static void check(int length, int x, int y) {
		int now = map[x][y];
		for (int i = 1; i <= length; i++) {
			boolean square = true;
			HashMap<Integer, Integer> hashMap = new HashMap<>();
			hashMap.put(now, 1);
			for (int j = 0; j < 3; j++) {
				int nx = x + dx[j] * i;
				int ny = y + dy[j] * i;
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					square = false;
					break;
				}
				hashMap.put(map[nx][ny], hashMap.getOrDefault(map[nx][ny], 0) + 1);
			}
			if (hashMap.get(now) == 4) {
				answer = Math.max(answer, (i + 1) * (i + 1));
			}
		}

	}
}