import java.io.*;
import java.util.*;

public class Main {
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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}

	static int N, answer;
	static PriorityQueue<Integer> head = new PriorityQueue<>((o1, o2) -> o2 - o1);
	static PriorityQueue<Integer> tail = new PriorityQueue<>();

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();

		for (int i = 0; i < N; i++) {
			int now = fr.nextInt();
			solve(now, i);
			System.out.println(answer);
			// System.out.println("standard = " + standard);
		}
	}

	private static void add(int now) {
		if (head.isEmpty()) {
			head.add(now);
		} else if (head.peek() < now) {
			tail.add(now);
		} else {
			head.add(now);
		}
	}

	private static void solve(int now, int index) {
		if (index % 2 == 0) {
			add(now);
			odd();
		} else {
			add(now);
			even();
		}
		answer = head.peek();
		// System.out.println("head = " + head + ", tail = " + tail);
	}

	private static void even() {
		while (head.size() != tail.size()) {
			if (head.size() > tail.size()) {
				tail.add(head.poll());
			} else if (head.size() < tail.size()) {
				head.add(tail.poll());
			}
		}
	}

	private static void odd() {
		while (head.size() - 1 != tail.size()) {
			if (head.size() - 1 > tail.size()) {
				tail.add(head.poll());
			} else if (head.size() - 1 < tail.size()) {
				head.add(tail.poll());
			}
		}
	}
}
