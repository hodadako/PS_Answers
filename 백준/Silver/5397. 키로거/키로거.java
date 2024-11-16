import java.util.*;
import java.io.*;

public class Main {
	static int TC;
	
	static class FastReader {
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

	static StringBuilder answer = new StringBuilder();
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		TC = sc.nextInt();

		for (int i = 0; i < TC; i++) {
			String now = sc.next();
			parse(now);
		}
		System.out.println(answer);
	}

	static void parse(String str) {
		Deque<Character> leftStack = new ArrayDeque<>();
		Deque<Character> rightStack = new ArrayDeque<>();

		for (char ch : str.toCharArray()) {
			if (Character.isLetterOrDigit(ch)) {
				leftStack.push(ch); 
			} else if (ch == '<') {
				if (!leftStack.isEmpty()) {
					rightStack.push(leftStack.pop()); 
				}
			} else if (ch == '>') {
				if (!rightStack.isEmpty()) {
					leftStack.push(rightStack.pop()); 
				}
			} else if (ch == '-' && !leftStack.isEmpty()) {
				leftStack.pop(); 
			}
		}
		
		StringBuilder result = new StringBuilder();
		while (!leftStack.isEmpty()) {
			result.append(leftStack.removeLast()); 
		}
		while (!rightStack.isEmpty()) {
			result.append(rightStack.pop());
		}
		
		answer.append(result.toString() + "\n");
	}
}
