import java.util.*;
import java.io.*;

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

	static int N;
	static HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
	static int[] arr = new int[1_000_001];
	static boolean[] visited = new boolean[1_000_001];
	// 현재 키보다 크거나 현재 키와의 차이가 1이상 나는 작은 키일 때
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();

		for (int i = 0; i < N; i++) {
			int now = fr.nextInt();
			arr[i] = now;
			TreeSet<Integer> set = map.getOrDefault(now, new TreeSet<>());
			set.add(i);
			map.put(now, set);
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				count++;
				pierce(arr[i], i);
			}
			// System.out.println("map = " + map);
		}
		System.out.println(count);
	}

	private static void pierce(int height, int index) {
		map.get(height).remove(index);
		visited[index] = true;
		while (true) {
			height--;
			boolean found = false;
			TreeSet<Integer> set = map.get(height);
			try {
				Integer higher = set.higher(index);
				set.remove(higher);
				visited[higher] = true;
				found = true;
				index = higher;
			} catch (NullPointerException e) {
			}

			if (!found) {
				break;
			}
		}
	}
}