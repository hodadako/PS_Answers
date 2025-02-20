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

	    long nextLong() {
	        return Long.parseLong(next());
	    }

	    double nextDouble() {
	        return Double.parseDouble(next());
	    }
	}

	static int N, S;
	static int[] dp;
	static ArrayList<Drawing> drawings = new ArrayList<>();
	static HashMap<Integer, Integer> inputs = new HashMap<>();

	static class Drawing {
		int height, price;

		public Drawing(int height, int price) {
			this.height = height;
			this.price = price;
		}

		@Override
		public String toString() {
			return " " + price + " " + height + " ";
		}
	}


	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		S = fr.nextInt();

		for (int i = 0; i < N; i++) {
			int h = fr.nextInt();
			int p = fr.nextInt();
			int temp = inputs.getOrDefault(h, 0);
			inputs.put(h, Math.max(p, temp));
		}

		for (int key : inputs.keySet()) {
			drawings.add(new Drawing(key, inputs.get(key)));
		}

		dp = new int[drawings.size()];

		Collections.sort(drawings, Comparator.comparing(o -> o.height));

		int result = 0;
		dp[0] = drawings.get(0).price;

		int l = drawings.size();
		for (int i = 0; i < l; i++) {
			dp[i] = drawings.get(i).price;
		}
		for (int i = 0; i < l; i++) {
			int low = i + 1;
			int high = l;
			int mid = 0;

			while (low < high) {
				mid = (low + high) / 2;
				if (Math.abs(drawings.get(i).height - drawings.get(mid).height) >= S) {
					high = mid;
				} else {
					low = mid + 1;
				}
			}

			int target = low;
			if (low == l) {
				continue;
			}
			while (drawings.get(low).height - S < drawings.get(target).height && target > i && drawings.get(target).height - drawings.get(i).height >= S) {
				dp[target] = Math.max(dp[target], dp[i] + drawings.get(target).price);
				target--;
			}

			target = low;
			while (drawings.get(low).height + S > drawings.get(target).height) {
				dp[target] = Math.max(dp[target], dp[i] + drawings.get(target).price);
				target++;

				if (target == l) {
					break;
				}
			}
		}

		for (int i = 0; i < l; i++) {
			result = Math.max(dp[i], result);
		}

		System.out.println(result);
	}
}