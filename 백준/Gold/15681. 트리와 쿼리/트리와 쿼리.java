import java.io.*;
import java.util.*;

public class Main {
	static int N, R, Q;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	static ArrayList<Integer> queries = new ArrayList<>();
	static int[] subTree;
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		R = fr.nextInt() - 1;
		Q = fr.nextInt();
		subTree = new int[N];
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
			adj.add(new ArrayList<>());
		}
		for (int i = 0; i < N - 1; i++) {
			int a = fr.nextInt() - 1;
			int b = fr.nextInt() - 1;
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		for (int i = 0; i < Q; i++) {
			int query = fr.nextInt() - 1;
			queries.add(query);
		}

		bfs(R);
		dfs(R);
		for (int q: queries) {
			System.out.println(subTree[q]);
		}
	}

	static void bfs(int root) {
		LinkedList<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N];
		visited[root] = true;
		q.add(root);
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : graph.get(cur)) {
				if (!visited[next]) {
					q.add(next);
					visited[next] = true;
					adj.get(cur).add(next);
				}
			}
		}
	}

	static void dfs(int u) {
		subTree[u]++;
		for (int v : adj.get(u)) {
			dfs(v);
			subTree[u] += subTree[v];
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