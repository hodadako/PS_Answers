import java.io.*;
import java.util.*;

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
	}

	static int N, M;
	static HashSet<Integer> check = new HashSet<>();
	static ArrayList<Integer> nums = new ArrayList<>();
	static int[] arr;

	private static void dfs(int depth) {
		if (depth == M) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(String.valueOf(arr[i]) + " ");
			}

			System.out.println(sb.toString());
			return;
		}

		int num = 0;
		for (int i = 0; i < nums.size(); i++) {
			int now = nums.get(i);
			if (num != now) {
				num = now;
				arr[depth] = now;
				dfs(depth + 1);
			}
		}
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		M = fr.nextInt();
		arr = new int[M];
		for (int i = 0; i < N; i++) {
			check.add(fr.nextInt());
		}

		nums.addAll(check);
		Collections.sort(nums);

		dfs(0);
	}
}