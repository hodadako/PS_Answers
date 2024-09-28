import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int[][] graph;
	static int[][] visited;
	static int N;
	static int islandNum = 1;
	static int answer = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Node>> edgeList = new ArrayList<>();

	static class Node {
		int x, y, count;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		graph = new int[N][N];
		visited = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				graph[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == 0 && graph[i][j] == 1) {
					ArrayList<Node> edges = findIsland(i, j, islandNum);
					edgeList.add(new ArrayList<>(edges));
					islandNum++;
				}
			}
		}

		for (int i = 0; i < islandNum - 1; i++) {
			for (int j = 0; j < islandNum - 1; j++) {
				if (i != j) {
					for (Node start : edgeList.get(i)) {
						for (Node end : edgeList.get(j)) {
							buildBridge(start, end);
						}
					}
				}
			}
		}

		System.out.println(answer);
	}

	static void print(int[][] graph) {
		System.out.println("____________________________________");
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("_____________________________________");
	}

	private static void buildBridge(Node start, Node end) {
		answer = Math.min(answer, (Math.abs(start.x - end.x) + Math.abs(start.y - end.y) - 1));
	}

	private static ArrayList<Node> findIsland(int x, int y, int islandNum) {
		LinkedList<Node> queue = new LinkedList<>();
		ArrayList<Node> result = new ArrayList<>();
		visited[x][y] = islandNum;
		Node start = new Node(x, y);
		queue.add(start);
		if (isEdge(start)) {
			result.add(start);
		}
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					continue;
				}

				if (graph[nx][ny] == 1 && visited[nx][ny] == 0) {
					visited[nx][ny] = islandNum;
					Node next = new Node(nx, ny);
					queue.add(next);
					if (isEdge(next)) {
						result.add(next);
					}
				}
			}
		}
		return result;
	}

	private static boolean isEdge(Node node) {
		int zeroCount = 0;
		for (int j = 0; j < 4; j++) {
			int tx = node.x + dx[j];
			int ty = node.y + dy[j];
			if (tx < 0 || ty < 0 || tx >= N || ty >= N) {
				continue;
			}

			if (graph[tx][ty] == 0) {
				zeroCount++;
			}
		}
		if (zeroCount > 0) {
			return true;
		}
		return false;
	}
}