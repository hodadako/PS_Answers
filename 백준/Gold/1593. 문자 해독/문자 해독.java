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

	static int N, M;
	static String W, S;
	static boolean check = true;
	static HashMap<Character, Integer> wMap = new HashMap<>();
	static HashMap<Character, Integer> sMap = new HashMap<>();

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		M = fr.nextInt();

		W = fr.next();
		S = fr.next();

		for (int i = 0; i < N; i++) {
			char c = W.charAt(i);
			wMap.put(c, wMap.getOrDefault(c, 0) + 1);
		}

		for (int i = 0; i < N; i++) {
			char c = S.charAt(i);
			sMap.put(c, sMap.getOrDefault(c, 0) + 1);
		}

		for (char key : wMap.keySet()) {
			if (sMap.containsKey(key)) {
				if (sMap.get(key) != wMap.get(key)) {
					check = false;
				}
			} else {
				check = false;
			}
		}
		int answer = 0;
		if (check) {
			answer++;
		}


		int start = 0;
		int end = N;
		while (end < M) {
			// System.out.println("S.charAt(start) = " + S.charAt(start));
			// System.out.println("S.charAt(end) = " + S.charAt(end));
			// System.out.println("wMap = " + wMap);
			// System.out.println("sMap = " + sMap);
			if (check) {
				if (S.charAt(start) == S.charAt(end)) {
					check = true;
					answer++;
				} else {
					check = false;
                    sMap.put(S.charAt(start), sMap.get(S.charAt(start)) - 1);
					sMap.put(S.charAt(end), sMap.getOrDefault(S.charAt(end), 0) + 1);
				}
			} else {
				if (S.charAt(start) == S.charAt(end)) {
					check = false;
				} else {
					check = true;
					// System.out.println("_____ 앞뒤 가 달라");
					sMap.put(S.charAt(start), sMap.get(S.charAt(start)) - 1);
					sMap.put(S.charAt(end), sMap.getOrDefault(S.charAt(end), 0) + 1);
					for (char key : wMap.keySet()) {
						if (sMap.containsKey(key)) {
							if (sMap.get(key) != wMap.get(key)) {
								check = false;
							}
						} else {
							check = false;
						}
					}
					// System.out.println(check);
					if (check) {
						answer++;
					}
				}
			}

			start++;
			end++;
		}

		System.out.println(answer);
	}
}