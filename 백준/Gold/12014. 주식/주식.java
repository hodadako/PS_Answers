import java.io.*;
import java.util.*;

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

	static int TC;
	static int[] nums;

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		TC = fr.nextInt();
		for (int i = 0; i < TC; i++) {
			int n = fr.nextInt();
			int k = fr.nextInt();
			nums = new int[n];
			for (int j = 0; j < n; j++) {
				nums[j] = fr.nextInt();
			}

			ArrayList<Integer> list = new ArrayList<>();

			list.add(nums[0]);

			for (int j = 1; j < n; j++) {
				int low = 0;
				int high = list.size() - 1;
				int mid = 0;
				while (low <= high) {
					mid = (low + high) / 2;
					if (nums[j] > list.get(mid)) {
						low = mid + 1;
					} else {
						high = mid - 1;
					}
				}

				if (list.get(list.size() - 1) < nums[j]) {
					list.add(nums[j]);
				} else {
					list.set(low, nums[j]);
				}
			}
			System.out.println("Case #" + (i + 1) + "\n" + (list.size() >= k ? 1 : 0));
		}
	}
}