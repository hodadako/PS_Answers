import java.io.*;
import java.util.*;

public class Main {
	static int N, M, start, end;
	static final int INF = (int) 1e9;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int[] parent, cost;
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		M = fr.nextInt();
		parent = new int[N];
		cost = new int[N];
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}
		Arrays.fill(cost, INF);

		for (int i = 0; i < M; i++) {
			int a = fr.nextInt() - 1;
			int b = fr.nextInt() - 1;
			int cost = fr.nextInt();
			graph.get(a).add(new Node(b, cost));
		}

		start = fr.nextInt() - 1;
		end = fr.nextInt() - 1;

		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		pq.add(new Node(start, 0));
		cost[start] = 0;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (cur.cost > cost[cur.num]) {
				continue;
			}
			for (Node next : graph.get(cur.num)) {
				if (cost[next.num] > cur.cost + next.cost) {
					cost[next.num] = cur.cost + next.cost;
					pq.add(new Node(next.num, cost[next.num]));
					parent[next.num] = cur.num;
				}
			}
		}

		int head = -1;
		int count = 1;
		int now = end;
		StringBuilder sb = new StringBuilder();
		sb.append(end + 1);
		while (head != start) {
			sb.append(" ");
			head = parent[now];
			sb.append(head + 1);
			now = head;
			count++;
		}
		System.out.println(cost[end]);
		System.out.println(count);
		StringBuilder answer = new StringBuilder();
		String[] arr = sb.toString().split(" ");
		for (int i = arr.length - 1; i >= 0; i--) {
			answer.append(arr[i] + " ");
		}
		System.out.println(answer);
	}

	static class Node {
		int num, cost;

		public Node(int num, int cost) {
			this.num = num;
			this.cost = cost;
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