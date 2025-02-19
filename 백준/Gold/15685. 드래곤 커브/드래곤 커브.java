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

	    double nextDouble() {
	        return Double.parseDouble(next());
	    }

	    long nextLong() {
	        return Long.parseLong(next());
	    }
	}

	static class Node {
		int x, y, dir;

		public Node(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "(" + x + ", " + y+ ")";
		}
	}

	static int N, x, y;
	static boolean[][] visited = new boolean[1001][1001];
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	static ArrayList<Node> curves = new ArrayList<>();

	static void print() {
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				System.out.print((visited[i][j] ? 1 : 0) + " ");
			}
			System.out.println();
		}
		System.out.println("___________________________");
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		for (int i = 0; i < N; i++) {
			y = fr.nextInt() + 10;
			x = fr.nextInt() + 10;
			int d = fr.nextInt();
			int g = fr.nextInt();
			visited[x][y] = true;

			for (int j = 0; j < g + 1; j++) {
				// System.out.println("j = " + j);
				// System.out.println("x = " + x);
				// System.out.println("y = " + y);
				// System.out.println("curves = " + curves);
				if (j == 0) {
					x += dx[d];
					y += dy[d];
					visited[x][y] = true;
					curves.add(new Node(dx[d], dy[d], d));
				} else {
					addNextGen();
				}
				// print();
			}
			curves.clear();
		}

		System.out.println(check());
	}

	private static int check() {
		int result = 0;
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				if (visited[i][j] && visited[i + 1][j] && visited[i][j + 1] && visited[i + 1][j + 1]) {
					result++;
				}
			}
		}
		return result;
	}

	private static void addNextGen() {
		ArrayList<Node> temp = new ArrayList<>();
		Collections.reverse(curves);
		for (Node n : curves) {
			int newDir = clockwise(uTurn(n.dir));
			x += dx[newDir];
			y += dy[newDir];
			visited[x][y] = true;
			temp.add(new Node(dx[newDir], dy[newDir], newDir));
		}
		Collections.reverse(curves);
		ArrayList<Node> next = new ArrayList<>();
		next.addAll(curves);
		next.addAll(temp);
		curves = next;
	}

	private static int uTurn(int i) {
		return (i + 2) % 4;
	}

	private static int clockwise(int i) {
		if (i - 1 == -1) {
			return 3;
		}
		return i - 1;
	}
}