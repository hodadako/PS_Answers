import java.util.*;
import java.io.*;

public class Main {
	static int T;
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		T = fr.nextInt();
		for (int i = 0; i < T; i++) {
			int N = fr.nextInt();
//			System.out.println("N = " + N);
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
			int[] root = new int[N + 1];
			for (int j = 0; j < N + 1; j++) {
				graph.add(new ArrayList<>());
				tree.add(new ArrayList<>());
			}

			for (int j = 0; j < N - 1; j++) {
				int a = fr.nextInt();
				int b = fr.nextInt();
				root[b]++;
				graph.get(a).add(b);
				graph.get(b).add(a);
				tree.get(a).add(b);
			}

			int head = 0;
			for (int j = 1; j <= N; j++) {
				if (root[j] == 0) {
					head = j;
					break;
				}
			}

//			System.out.println(head);

			int[] height = findHeight(head, N, tree);


			int start = fr.nextInt();
			int end = fr.nextInt();
//			System.out.println("end = " + end);
			int answer = 0;
			boolean[] visited = new boolean[N + 1];
			LinkedList<int[]> q = new LinkedList<>();
			q.add(new int[] {start, start});
			visited[start] = true;
			while (!q.isEmpty()) {
				int[] now = q.poll();
				if (now[0] == end) {
					answer = now[1];
					break;
				}
				for (int next : graph.get(now[0])) {
					if (visited[next]) {
						continue;
					}
					visited[next] = true;
//					System.out.println("______________________");
//					System.out.println("now = " + now[0]);
//					System.out.println("next = " + next);
//					System.out.println("parent = " + changeParent(now[1], next, height));
					q.add(new int[] {next, changeParent(now[1], next, height)});
				}
			}
//			System.out.println(Arrays.toString(height));
			System.out.println(answer);
		}
	}

	static int changeParent(int a, int b, int[] height) {
		if (height[a] > height[b]) {
			return b;
		}
		return a;
	}

	static int[] findHeight(int root, int n, ArrayList<ArrayList<Integer>> graph) {
//		System.out.println(graph);
		LinkedList<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[n + 1];
		int[] result = new int[n + 1];
		q.add(new int[] {root, 0});
		visited[root] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int next : graph.get(now[0])) {
//				System.out.println("next int = " + next);
				if (visited[next]) {
					continue;
				}
				visited[next] = true;
				result[next] = now[1] + 1;
				q.add(new int[]{next, now[1] + 1});
			}
		}
//		System.out.println("result = " + Arrays.toString(result));
		return result;
	}

	static int getParent(int a, int b, int[] parent) {
		if (parent[a] == b) {

		} else if (parent[b] == a) {

		}
		return 0;
	}

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
	}
}