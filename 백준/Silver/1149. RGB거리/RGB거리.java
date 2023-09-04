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

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int[][] costs = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                costs[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n - 1; i++) {
            costs[i + 1][0] += Math.min(costs[i][1], costs[i][2]);
            costs[i + 1][1] += Math.min(costs[i][0], costs[i][2]);
            costs[i + 1][2] += Math.min(costs[i][0], costs[i][1]);
        }

        Arrays.sort(costs[n - 1]);
        System.out.println(costs[n-1][0]);
    }
}