import java.io.*;
import java.util.*;

public class Main {
	static int V, E;
	static final int INF = (int) 1e9;
	static int[][] graph;
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		V = fr.nextInt();
		graph = new int[V + 1][V + 1];
		for (int i = 0; i < V + 1; i++) {
			for (int j = 0; j < V + 1; j++) {
				graph[i][j] = INF;
			}
		}

		E = fr.nextInt();
		for (int i = 0; i < E; i++) {
			graph[fr.nextInt()][fr.nextInt()] = fr.nextInt();
		}

		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				for (int k = 1; k <= V; k++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}

		int answer = INF;
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (graph[i][j] + graph[j][i] < INF) {
					answer = Math.min(answer, graph[i][j] + graph[j][i]);
				}
			}
		}

		System.out.println(answer != INF ? answer : -1);
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