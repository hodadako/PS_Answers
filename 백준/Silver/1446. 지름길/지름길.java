import java.util.*;
import java.io.*;
import java.util.function.IntFunction;

class Main {
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

	static class Vertex implements Comparable<Vertex> {
		int next, distance;

		public Vertex(int next, int distance) {
			this.next = next;
			this.distance = distance;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.distance - o.distance;
		}

		@Override
		public String toString() {
			return "Vertex{" +
				"next=" + next +
				", distance=" + distance +
				'}';
		}
	}

	// 각 지름길 시작에서
	// 각 end 까지의 최소 거리를 구하면 됨
	static int N, D;
	static HashMap<Integer, ArrayList<Vertex>> graph = new HashMap<>();
	static TreeMap<Integer, Integer> distanceMap = new TreeMap<>();
	static PriorityQueue<Vertex> pq = new PriorityQueue<>();

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		D = fr.nextInt();

		for (int i = 0; i < N; i++) {
			int start = fr.nextInt();
			int end = fr.nextInt();
			int distance = fr.nextInt();
			if (end > D) {
				continue;
			}
			if (distance > end - start) {
				continue;
			}
			ArrayList<Vertex> list = graph.getOrDefault(start, new ArrayList<>());
			list.add(new Vertex(end, distance));
			graph.put(start, list);
			pq.add(new Vertex(start, start));
			distanceMap.put(end, end);
		}
		// System.out.println("pq = " + pq);
		// System.out.println("graph = " + graph);
		dijkstra();

		// System.out.println(distanceMap);
		int answer = D;
		for (int i : distanceMap.keySet()) {
			answer = Math.min(answer, D - i + distanceMap.get(i));
		}
		System.out.println(answer);
	}

	static int getOptimalDistance(int distance, int next) {
		int result = distance;
		for (int key : distanceMap.keySet()) {
			if (key > next) {
				break;
			}
			result = Math.min(result, distance - key + distanceMap.get(key));
		};
		return result;
	}

	private static void dijkstra() {
		while (!pq.isEmpty()) {
			Vertex v = pq.poll();
			int distance = getOptimalDistance(v.distance, v.next);

			// System.out.println("v.next = " + v.next);
			// System.out.println("distance = " + distance);
			if (graph.containsKey(v.next)) {
				for (Vertex u : graph.get(v.next)) {
					// System.out.println("u.distance = " + u.distance);
					// System.out.println("u.next = " + u.next);
					if (distanceMap.get(u.next) > distance + u.distance) {
						distanceMap.put(u.next, distance + u.distance);
					}
				}
			}
		}
	}
}