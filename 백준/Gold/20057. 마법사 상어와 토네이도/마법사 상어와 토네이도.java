import java.util.*;
import java.io.*;

class Main {
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static int n, answer;
    static int[][] sand;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][][] percent = {{{1, 1, 1}, {0, 1, 7}, {-1, 1, 10}, {0, 2, 2}, {1, -1, 1}, {0, -1, 7}, {-1, -1, 10}, {0, -2, 2}, {-2, 0, 5}, {-1, 0}},
                                {{-1, 1, 1}, {-1, 0, 7}, {-1, -1, 10}, {-2, 0, 2}, {1, 1, 1}, {1, 0, 7}, {1, -1, 10}, {2, 0, 2}, {0, -2, 5}, {0, -1}},
                                {{-1, -1, 1}, {0, -1, 7}, {1, -1, 10}, {0, -2, 2}, {-1, 1, 1}, {0, 1, 7}, {1, 1, 10}, {0, 2, 2}, {2, 0, 5}, {1, 0}},
                                {{1, -1, 1}, {1, 0, 7}, {1, 1, 10}, {2, 0, 2}, {-1, -1, 1}, {-1, 0, 7}, {-1, 1, 10}, {-2, 0, 2}, {0, 2, 5}, {0, 1}}};

    private static void blow(int direction, int x, int y) {
        int total = sand[x][y], original = sand[x][y];
        for (int i = 0; i < percent[direction].length - 1; i++) {
            int[] now = percent[direction][i];
            double cur = (double) sand[x][y];
            cur = cur / 100 * now[2];
            total -= (int) cur;
            int nx = x + now[0], ny = y + now[1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                answer += (int) cur;
            } else {
                sand[nx][ny] += (int) cur;
            }
        }

        int[] last = percent[direction][percent[direction].length - 1];
        int nx = x + last[0], ny = y + last[1];
        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
            answer += total;
        } else {
            sand[nx][ny] += total;
        }
        sand[x][y] -= original;
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(sand[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("___________________________________");
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        sand = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sand[i][j] = sc.nextInt();
            }
        }

        int x = n / 2,  y = n / 2, timer = 0, direction = 1;
        while (x >= 0 && x < n && y >= 0 && y < n) {
            if (direction != 0) {
                for (int i = 0; i < timer * 2 + 1; i++) {
                    x += dx[direction];
                    y += dy[direction];
                    if (x < 0 || x >= n || y < 0 || y >= n) break;
                    blow(direction, x, y);
                }
            } else {
                for (int i = 0; i < timer * 2; i++) {
                    x += dx[direction];
                    y += dy[direction];
                    if (x < 0 || x >= n || y < 0 || y >= n) break;
                    blow(direction, x, y);
                }
            }

            if (direction == 3) {
                x += dx[direction];
                y += dy[direction];
                blow(direction, x, y);
            }
            direction++;
            if (direction > 3) {
                timer++;
                direction = 0;
            }
        }

        System.out.println(answer);
    }
}