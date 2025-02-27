import java.util.*;
import java.io.*;

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
	}

	static int N, M;
	static int[][] scoreboard;
	static boolean[] visited;
	static int[] invisibleRows;
	static int[] acCounts;
	static int[] maxCounts;
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		scoreboard = new int[N][M];
		visited = new boolean[M];
		invisibleRows = new int[N];
		acCounts = new int[N];
		maxCounts = new int[N];
 		for (int i = 0; i < N; i++) {
			 acCounts[i] = sc.nextInt();
			 maxCounts[i] = acCounts[i];
			for (int j = 0; j < M; j++) {
				scoreboard[i][j] = sc.nextInt();
				if (scoreboard[i][j] == -1) {
					invisibleRows[i]++;
					if (acCounts[i] == 0) {
						scoreboard[i][j] = 0;
					}
				} else if (scoreboard[i][j] == 1) {
					visited[j] = true;
					acCounts[i]--;
				}
			}
		}

		 fillBlanks();

		// for (int i = 0; i < N; i++) {
		// 	for (int j = 0; j < M; j++) {
		// 		System.out.print(scoreboard[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }

		System.out.println(checkAllSolve() && checkMaximum() && checkLeastOne() ? "YES" : "NO");
	}

	static boolean checkLeastOne() {
		for (int i = 0; i < N; i++) {
			if (maxCounts[i] == 0) {
				return false;
			}
		}
		return true;
	}

	static boolean checkMaximum() {
		for (int i = 0; i < N; i++) {
			if (maxCounts[i] == M) {
				return false;
			}
		}
		return true;
	}
	
	static boolean checkAllSolve() {
		for (int i = 0; i < M; i++) {
			if (!visited[i]) {
				return false;
			}
		}
		return true;
	}

	static boolean fillBlanks() {
		int possibleAnswer = 0;
		int empty = M;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (scoreboard[j][i] == -1) {
					if (visited[i]) {
						scoreboard[j][i] = 0;
					} else if (acCounts[j] > 0) {
						scoreboard[j][i] = 1;
						acCounts[j]--;
						visited[i] = true;
					} else {
						scoreboard[j][i] = 0;
					}
				}
			}
 		}
		//
		// System.out.println(Arrays.toString(visited));

		return possibleAnswer >= empty;
	}
}