import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int n = fr.nextInt();
		int k = fr.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = fr.nextInt();
		}

		if (n == 1) {
			System.out.println(1);
			return;
		}

		int start = 0;
		int end = 1;
		int answer = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(arr[start], 1);

		while (end < n) {
			map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
			// System.out.println("start = " + start);
			// System.out.println(end + " " + map);
			if (map.get(arr[end]) > k) {
				// System.out.println(end);
				answer = Math.max(answer, end - start);
				while (map.get(arr[end]) > k) {
					map.put(arr[start], map.get(arr[start]) - 1);
					start++;
				}
			}
			end++;
		}
		answer = Math.max(answer, end - start);
		System.out.println(answer);
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
	}
}