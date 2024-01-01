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

	    double nextDouble() {
	        return Double.parseDouble(next());
	    }

	    long nextLong() {
	        return Long.parseLong(next());
	    }
	}


    public static void main(String[] args) {
		FastReader fr = new FastReader();

		String s1 = fr.next();
		String s2 = fr.next();

		HashMap<Character, Integer> hashMap1 = new HashMap<>();
		HashMap<Character, Integer> hashMap2 = new HashMap<>();

		for (int i = 0; i < s1.length(); i++) {
			hashMap1.put(s1.charAt(i), hashMap1.getOrDefault(s1.charAt(i), 0) + 1);
		}

		for (int i = 0; i < s2.length(); i++) {
			hashMap2.put(s2.charAt(i), hashMap2.getOrDefault(s2.charAt(i), 0) + 1);
		}

		int answer = 0;
		for (Character c : hashMap1.keySet()) {
			if (!hashMap2.containsKey(c)) {
				answer += hashMap1.get(c);
			} else {
				answer += Math.abs(hashMap1.get(c) - hashMap2.get(c));
			}
		}

		for (Character c : hashMap2.keySet()) {
			if (!hashMap1.containsKey(c)) {
				answer += hashMap2.get(c);
			}
		}

		System.out.println(answer) ;
    }
}