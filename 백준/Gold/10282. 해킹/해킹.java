import java.io.*;
import java.util.*;

public class Main {
	static int TC;
	static final int INF = (int) 1e8;
	static ArrayList<ArrayList<int[]>> graph;
	static int[] cost;
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		TC = fr.nextInt();
		for (int i = 0; i < TC; i++) {
			int n = fr.nextInt();
			int d = fr.nextInt();
			int c = fr.nextInt();
			graph = new ArrayList<>();
			cost = new int[n + 1];
			for (int j = 0; j <= n; j++) {
				graph.add(new ArrayList<>());
			}
			for (int j = 0; j < d; j++) {
				int a = fr.nextInt();
				int b = fr.nextInt();
				int s = fr.nextInt();
				graph.get(b).add(new int[]{a, s});
			}
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
			pq.add(new int[]{c, 0});
			Arrays.fill(cost, INF);
			cost[c] = 0;
			while (!pq.isEmpty()) {
				int[] now = pq.poll();
				for (int[] edge : graph.get(now[0])) {
					if (cost[edge[0]] > cost[now[0]] + edge[1]) {
						cost[edge[0]] = cost[now[0]] + edge[1];
						pq.add(new int[]{edge[0], cost[edge[0]]});
					}
				}
			}
			int total = 0;
			int ans = 0;
			// System.out.println(Arrays.toString(cost));
			for (int j = 1; j < n + 1; j++) {
				if (cost[j] < INF) {
					total++;
					ans = Math.max(ans, cost[j]);
				}
			}
			System.out.println(total + " " + ans);
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