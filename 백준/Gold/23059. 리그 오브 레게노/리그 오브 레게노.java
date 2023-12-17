import java.io.*;
import java.util.*;

public class Main {
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
	}

	static int N;
	static int cnt;
	static HashMap<String, ArrayList<String>> graph = new HashMap<>();
	static HashMap<String, Integer> inDegree = new HashMap<>();
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		for (int i = 0; i < N; i++) {
			String item1 = fr.next();
			String item2 = fr.next();

			graph.putIfAbsent(item1, new ArrayList<>());
			graph.putIfAbsent(item2, new ArrayList<>());
			graph.get(item1).add(item2);

			inDegree.putIfAbsent(item1, 0);
			inDegree.put(item2, inDegree.getOrDefault(item2, 0) + 1);
		}

		topologySort();
		if (cnt != graph.size()) {
			System.out.println(-1);
		} else {
			System.out.println(answer.toString());
		}
	}

	private static void topologySort() {
		PriorityQueue<String> q = new PriorityQueue<>();
		PriorityQueue<String> temp = new PriorityQueue<>();

		for (String key : inDegree.keySet()) {
			if (inDegree.get(key) == 0) {
				q.offer(key);
			}
		}

		while (!q.isEmpty()) {
			String now = q.poll();
			answer.append(now + "\n");
			cnt++;
			for (String next : graph.get(now)) {
				inDegree.put(next, inDegree.get(next) - 1);
				if (inDegree.get(next) == 0) {
					temp.offer(next);
				}
			}

			if (q.isEmpty()) {
				q.addAll(temp);
				temp.clear();
			}
		}
	}
}
