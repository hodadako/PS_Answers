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
	}

	static void roll(int order, Dice dice) {
		int nx = x + dx[order];
		int ny = y + dy[order];
		if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
			return;
		}
		x = nx;
		y = ny;

		if (order == 1) {
			rollEast(dice);
		} else if (order == 2) {
			rollWest(dice);
		} else if (order == 3) {
			rollNorth(dice);
		} else {
			rollSouth(dice);
		}

		dice.printTop();
	}

	static void rollEast(Dice dice) {
		int temp = dice.right;
		dice.right = dice.top;
		dice.top = dice.left;
		dice.left = dice.bottom;
		if (map[x][y] == 0) {
			dice.bottom = temp;
			map[x][y] = dice.bottom;
		} else {
			dice.bottom = map[x][y];
			map[x][y] = 0;
		}
	}

	static void rollWest(Dice dice) {
		int temp = dice.left;
		dice.left = dice.top;
		dice.top = dice.right;
		dice.right = dice.bottom;
		if (map[x][y] == 0) {
			dice.bottom = temp;
			map[x][y] = dice.bottom;
		} else {
			dice.bottom = map[x][y];
			map[x][y] = 0;
		}
	}

	static void rollNorth(Dice dice) {
		int temp = dice.rear;
		dice.rear = dice.top;
		dice.top = dice.front;
		dice.front = dice.bottom;
		if (map[x][y] == 0) {
			dice.bottom = temp;
			map[x][y] = dice.bottom;
		} else {
			dice.bottom = map[x][y];
			map[x][y] = 0;
		}
	}

	static void rollSouth(Dice dice) {
		int temp = dice.front;
		dice.front = dice.top;
		dice.top = dice.rear;
		dice.rear = dice.bottom;
		if (map[x][y] == 0) {
			dice.bottom = temp;
			map[x][y] = dice.bottom;
		} else {
			dice.bottom = map[x][y];
			map[x][y] = 0;
		}
	}


	static class Dice {
		int top, bottom, left, right, front, rear;

		public Dice() {
			this.top = 0;
			this.bottom = 0;
			this.left = 0;
			this.right = 0;
			this.front = 0;
			this.rear = 0;
		}

		void printTop() {
			System.out.println(this.top);
		}

		@Override
		public String toString() {
			System.out.println("________________________");
			return "  " + front + " \n" + left + " " + top + " " + right + " \n  " + rear + " \n  " + bottom;
		}
	}

	static int N, M, x, y, K;
	static int[][] map;
	static int[] dx = {0, 0, 0, -1, 1};
	static int[] dy = {0, 1, -1, 0, 0};

	static void printMap() {
		System.out.println("_____________________________");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("_____________________________");
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		N = fr.nextInt();
		M = fr.nextInt();
		x = fr.nextInt();
		y = fr.nextInt();
		K = fr.nextInt();

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = fr.nextInt();
			}
		}

		Dice dice = new Dice();

		for (int i = 0; i < K; i++) {
			int now = fr.nextInt();
			roll(now, dice);
			// System.out.println("order = " + now);
			// System.out.println(dice);
			// printMap();
		}

	}
}
