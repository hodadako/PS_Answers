import java.io.*;
import java.util.*;

public class Main {
	static int T;
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		T = fr.nextInt();
		for (int i = 0; i < T; i++) {
			int n = fr.nextInt();

			HashMap<String, String> parent = new HashMap<>();
			HashMap<String, Integer> count = new HashMap<>();
			for (int j = 0; j < n; j++) {
				String a = fr.next();
				String b = fr.next();
				parent.putIfAbsent(a, a);
				parent.putIfAbsent(b, b);
				count.computeIfAbsent(a, s -> count.getOrDefault(s, 0) + 1);
				count.computeIfAbsent(b, s -> count.getOrDefault(s, 0) + 1);
				union(parent, count, a, b);
				System.out.println(count.get(findRoot(a, parent)));
			}
		}
	}

	static String findRoot(String s, HashMap<String, String> parent) {
		String root = parent.get(s);
		if (!root.equals(s)) {
			root = findRoot(root, parent);
			parent.put(s, root); 
		}
		return root;
	}


	static void union(HashMap<String, String> parent, HashMap<String, Integer> count, String a, String b) {
		String aParent = findRoot(a, parent);
		String bParent = findRoot(b, parent);
		if (aParent != bParent) {
			parent.put(bParent, aParent);
			count.put(aParent, count.getOrDefault(aParent, 0) + count.get(bParent));
		}
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