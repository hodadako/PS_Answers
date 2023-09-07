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

    static class Node {
        int x, y, num;

        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int tc = sc.nextInt();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        for (int i = 0; i < tc; i++) {
            int n = sc.nextInt();
            int[][] map = new int[2][n];
            int[][] dp = new int[2][n];
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < n; k++) {
                    map[j][k] = sc.nextInt();
                    dp[j][k] = map[j][k];
                }
            }
            if (n == 1) {
                System.out.println(Math.max(map[0][0], map[1][0]));
            } else if (n == 2) {
                System.out.println(Math.max(map[0][0] + map[1][1], map[0][1] + map[1][0]));
            } else {
                dp[0][1] += dp[1][0];
                dp[1][1] += dp[0][0];
                for (int k = 2; k < n; k++) {
                    dp[0][k] += Math.max(Math.max(dp[1][k - 2], dp[0][k - 2] + map[1][k - 1]), dp[1][k - 1]);
                    dp[1][k] += Math.max(Math.max(dp[0][k - 2], dp[1][k - 2] + map[0][k - 1]), dp[0][k - 1]);
                }

                System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
            }
        }
    }
}