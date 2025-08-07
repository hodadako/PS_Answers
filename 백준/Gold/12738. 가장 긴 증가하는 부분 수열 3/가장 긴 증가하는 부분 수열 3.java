import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = fr.nextInt();
		}

		ArrayList<Integer> list = new ArrayList<>();
		list.add(arr[0]);
		for (int i = 1; i < N; i++) {
			int low = 0;
			int high = list.size();
			int target = 0;
			while (low < high) {
				target = (low + high) / 2;
				if (list.get(target) < arr[i]) {
					low = target + 1;
				} else {
					high = target;
				}
			}
			if (high == list.size()) {
				list.add(arr[i]);
			} else {
				list.set(high, arr[i]);
			}
		}
		System.out.println(list.size());
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