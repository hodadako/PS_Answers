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

	static int H, W, R, C, D;
	static int[][] ruleSetA;
	static int[][] ruleSetB;
	static HashMap<Order, Integer>[][] visited;
	static int noDustCount, moveCount;
	static boolean hasCycle;

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) {
		FastReader fr = new FastReader();

		H = fr.nextInt();
		W = fr.nextInt();
		R = fr.nextInt();
		C = fr.nextInt();
		D = fr.nextInt();
		ruleSetA = new int[H][W];
		ruleSetB = new int[H][W];
		visited = new HashMap[H][W];

		for (int i = 0; i < H; i++) {
			String now = fr.next();
			for (int j = 0; j < W; j++) {
				ruleSetA[i][j] = Character.getNumericValue(now.charAt(j));
			}
		}

		for (int i = 0; i < H; i++) {
			String now = fr.next();
			for (int j = 0; j < W; j++) {
				ruleSetB[i][j] = Character.getNumericValue(now.charAt(j));
			}
		}

		move();

		System.out.println(moveCount);

		// for (int i = 0; i < H; i++) {
		// 	for (int j = 0; j < W; j++) {
		// 		System.out.print(visited[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }
	}

	static void move() {
		LinkedList<Node> q = new LinkedList<>();
		q.add(new Node(R, C, D));

		while (!q.isEmpty() && !hasCycle) {
			Node cur = q.poll();
			int dir = cur.direction;

			// System.out.println("cur.x = " + cur.x + " cur.y = " + cur.y + " dir = " + dir);

			if (cur.x < 0 || cur.y < 0 || cur.x >= H || cur.y >= W) {
				moveCount -= noDustCount;
				break;
			}

			if (visited[cur.x][cur.y] == null) {
				visited[cur.x][cur.y] = new HashMap<>();
				dir = getNextDirection(dir + ruleSetA[cur.x][cur.y]);
				Order key = new Order(dir, 1, cur.direction);
				visited[cur.x][cur.y].put(key, visited[cur.x][cur.y].getOrDefault(key, 0) + 1);
				noDustCount = 0;
			} else {
				noDustCount++;
				Order oldKey = new Order(dir, 2, cur.direction);
				if (visited[cur.x][cur.y].containsKey(oldKey)) {
					if (visited[cur.x][cur.y].get(oldKey) > 3800) {
						// System.out.println("check");
						moveCount -= noDustCount;
						hasCycle = true;
					}
				}
				dir = getNextDirection(dir + ruleSetB[cur.x][cur.y]);
				Order key = new Order(dir, 2, cur.direction);

				visited[cur.x][cur.y].put(key, visited[cur.x][cur.y].getOrDefault(key, 0) + 1);

			}

			moveCount++;
			q.add(new Node(cur.x + dx[dir], cur.y + dy[dir], dir));
		}
	}

	static int getNextDirection(int n) {
		return n % 4;
	}

	static class Node {
		int x, y, direction;

		public Node(int x, int y, int direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}
	}

	static class Order {
		int direction, ruleSet, prevDirection;

		public Order(int direction, int ruleSet, int prevDirection) {
			this.direction = direction;
			this.ruleSet = ruleSet;
			this.prevDirection = prevDirection;
		}

		@Override
		public String toString() {
			return "Order{" +
				"direction=" + direction +
				", ruleSet=" + ruleSet +
				", prevDirection=" + prevDirection +
				'}';
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;

			Order order = (Order)o;
			return direction == order.direction && ruleSet == order.ruleSet && prevDirection == order.prevDirection;
		}

		@Override
		public int hashCode() {
			int result = direction;
			result = 31 * result + ruleSet;
			result = 31 * result + prevDirection;
			return result;
		}
	}
}