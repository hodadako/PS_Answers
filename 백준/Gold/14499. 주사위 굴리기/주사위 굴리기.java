import java.util.*;
import java.io.*;

class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m;
    static int[][] map;
    static int[] orders;

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

    static class Dice {
        int top = 1, now = 6, x, y;
        int[] status = new int[7];
        int[][] next = {{0, 2, 0}, {4, 6, 3}, {0, 5, 0}, {0, 1, 0}};

        void print() {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(next[i][j] + " ");
                }
                System.out.println();
            }
        }

        void move(int order) {
            if (order == 1) {
                right();
            } else if (order == 2) {
                left();
            } else if (order == 3) {
                up();
            } else {
                down();
            }
        }

        void down() {
            int temp = next[0][1];
            for (int i = 0; i < 3; i++) {
               next[i][1] = next[i + 1][1];
            }
            next[3][1] = temp;
            top = next[3][1];
            now = next[1][1];
        }

        void up() {
            int temp = next[3][1];
            for (int i = 3; i > 0; i--) {
                next[i][1] = next[i - 1][1];
            }
            next[0][1] = temp;
            top = next[3][1];
            now = next[1][1];
        }
        void left() {
            int temp = next[1][2];
            for (int i = 2; i > 0; i--) {
                next[1][i] = next[1][i - 1];
            }
            next[1][0] = next[3][1];
            next[3][1] = temp;
            top = next[3][1];
            now = next[1][1];
        }

        void right() {
            int temp = next[1][0];
            for (int i = 0; i < 2; i++) {
                next[1][i] = next[1][i + 1];
            }
            next[1][2] = next[3][1];
            next[3][1] = temp;
            top = next[3][1];
            now = next[1][1];
        }

        public Dice(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        int x = sc.nextInt(), y = sc.nextInt(), k = sc.nextInt();

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        Dice dice = new Dice(x, y);
        orders = new int[k];
        for (int i = 0; i < k; i++) {
            orders[i] = sc.nextInt();
            int nx = dice.x + dx[orders[i] - 1], ny = dice.y + dy[orders[i] - 1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            dice.x = nx;
            dice.y = ny;
            dice.move(orders[i]);
//            System.out.println("dice.now = " + dice.now);
//            System.out.println("orders[i] = " + orders[i]);
//            System.out.println("dots = " + dice.x + " " + dice.y);
//            dice.print();
//            System.out.println("dice.status = " + Arrays.toString(dice.status));
            if (map[dice.x][dice.y] == 0) {
                map[dice.x][dice.y] = dice.status[dice.now];
            } else {
                dice.status[dice.now] = map[dice.x][dice.y];
                map[dice.x][dice.y] = 0;
            }


            System.out.println(dice.status[dice.top]);
//            System.out.println("_____________________________________");
        }
    }
}