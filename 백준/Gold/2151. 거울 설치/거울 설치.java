import java.io.*;
import java.util.*;

public class Main {
	static int N, sx1 = -1, sy1, sx2, sy2;
	static char[][] map;
	static int[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static HashMap<Vertex, Integer> cost = new HashMap<>();
	static HashMap<Vertex, HashSet<Vertex>> graph = new HashMap<>();
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		map = new char[N][N];
		visited = new int[N][N];
		for (int i = 0; i < N; i++) {
			String now = fr.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = now.charAt(j);
				if (map[i][j] == '#') {
					if (sx1 == -1) {
						sx1 = i;
						sy1 = j;
					} else {
						sx2 = i;
						sy2 = j;
					}
				}
			}
		}

		// System.out.println(sx1 + " " + sy1);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '#' || map[i][j] == '!') {
					putVertex(i , j);
				}
			}
		}

		PriorityQueue<Vertex> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		pq.add(new Vertex(sx1, sy1, 0));
		while (!pq.isEmpty()) {
			Vertex v = pq.poll();
			if (cost.containsKey(v)) {
				if (cost.get(v) < v.cost) {
					continue;
				}
			}
			// System.out.println(v);
			for (Vertex next : graph.get(v)) {
				if (!cost.containsKey(next) || cost.get(next) > v.cost + 1) {
					cost.put(next, map[next.x][next.y] == '!' ? v.cost + 1 : v.cost);
					pq.add(new Vertex(next.x, next.y, map[next.x][next.y] == '!' ? v.cost + 1 : v.cost));
				}
			}
		}

		// System.out.println(cost);
		System.out.println(cost.get(new Vertex(sx2, sy2, 0)));
		// System.out.println(graph);
	}

	static void putVertex(int i, int j) {
		Vertex start = new Vertex(i, j, 0);
		for (int k = 0; k < 4; k++) {
			int nx = i;
			int ny = j;
			while (true) {
				nx += dx[k];
				ny += dy[k];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					nx -= dx[k];
					ny -= dy[k];
					break;
				}
				if (map[nx][ny] == '*') {
					break;
				}
				if (map[nx][ny] == '#' || map[nx][ny] == '!') {
					HashSet<Vertex> neighbours = graph.getOrDefault(start, new HashSet<>());
					Vertex e = new Vertex(nx, ny, 0);
					neighbours.add(e);
					graph.put(start, neighbours);
					HashSet<Vertex> neighbours2 = graph.getOrDefault(e, new HashSet<>());
					neighbours2.add(start);
					graph.put(e, neighbours2);
				}
			}
		}
	}

	static class Vertex {
		int x, y, cost;

		public Vertex(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Vertex) {
				Vertex v = (Vertex) o;
				return x == v.x && y == v.y;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return (x + " " + y).hashCode();
		}

		@Override
		public String toString() {
			return "(" + x + ", " + y + ", " + cost + ")";
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