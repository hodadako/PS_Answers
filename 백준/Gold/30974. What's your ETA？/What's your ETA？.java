import java.util.*;
import java.io.*;

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
	}

	static final int MAX_LIMIT = 10_000_000;
	static boolean[] isPrime = new boolean[MAX_LIMIT + 1];

	static void sieveOfEratosthenes(int limit) {
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i * i <= limit; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= limit; j += i) {
					isPrime[j] = false;
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int next;
		long distance;

		public Node(int next, long distance) {
			this.next = next;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.distance, o.distance);
		}
	}

	static int N, M;
	static int[] disasterNumbers;
	static final long INF = Long.MAX_VALUE;
	static long[] distances;
	static HashMap<Integer, ArrayList<Node>> graph = new HashMap<>();

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		disasterNumbers = new int[N + 1];
		distances = new long[N + 1];
		Arrays.fill(distances, INF);

		for (int i = 1; i < N + 1; i++) {
			disasterNumbers[i] = sc.nextInt();
		}

		for (int i = 0; i < N + 1; i++) {
			graph.put(i, new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int distance = sc.nextInt();
			graph.get(a).add(new Node(b, distance));
			graph.get(b).add(new Node(a, distance));
		}

		sieveOfEratosthenes(MAX_LIMIT);

		dijkstra(1);

		System.out.println(distances[N] != INF ? distances[N] : "Now where are you?");
	}

	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		distances[start] = 0;
		while (!pq.isEmpty()) {
			Node node = pq.poll();

			if (node.distance > distances[node.next]) {
				continue;
			}

			for (Node u : graph.get(node.next)) {
				long newDist = distances[node.next] + u.distance;
				if (newDist < distances[u.next] && isPrime(disasterNumbers[node.next] + disasterNumbers[u.next])) {
					distances[u.next] = newDist;
					pq.add(new Node(u.next, newDist));
				}
			}
		}
	}

	static boolean isPrime(int num) {
		return isPrime[num];
	}
}
