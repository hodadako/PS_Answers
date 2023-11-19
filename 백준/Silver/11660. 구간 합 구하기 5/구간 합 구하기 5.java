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

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] graph = new int[n][n];
        int[][] cumSum = new int[n][n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            if (i == 0) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = sc.nextInt();
                    sum += graph[i][j];
                    cumSum[i][j] = sum;
                }
            } else {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = sc.nextInt();
                    if (j == 0) {
                        cumSum[i][j] = cumSum[i - 1][j] + graph[i][j];
                    } else {
                        cumSum[i][j] = cumSum[i - 1][j] + cumSum[i][j - 1] - cumSum[i - 1][j - 1] + graph[i][j];
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int x1 = sc.nextInt() - 1, y1 = sc.nextInt() - 1, x2 = sc.nextInt() - 1, y2 = sc.nextInt() - 1;
            if (x1 == x2 && y1 == y2) {
                System.out.println(graph[x1][y1]);
            } else {
                int total = cumSum[x2][y2];
                int count = 0;
                if (x1 > 0) {
                    total -= cumSum[x1 - 1][y2];
                    count++;
                }
                if (y1 > 0) {
                    total -= cumSum[x2][y1 - 1];
                    count++;
                }

                if (count == 2) {
                    total += cumSum[x1 - 1][y1 - 1];
                }
                System.out.println(total);
            }
        }
    }
}