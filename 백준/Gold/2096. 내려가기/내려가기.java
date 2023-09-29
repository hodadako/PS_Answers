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

    static int n;
    static int[][] maxGraph, minGraph;

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        maxGraph = new int[n][3];
        minGraph = new int[n][3];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                for (int j = 0; j < 3; j++) {
                    maxGraph[i][j] = minGraph[i][j] = sc.nextInt();
                 }
            } else {
                for (int j = 0; j < 3; j++) {
                    maxGraph[i][j] = minGraph[i][j] = sc.nextInt();
                }
                maxGraph[i][0] += Math.max(maxGraph[i - 1][0], maxGraph[i - 1][1]);
                maxGraph[i][1] += Math.max(Math.max(maxGraph[i - 1][0], maxGraph[i - 1][1]), maxGraph[i - 1][2]);
                maxGraph[i][2] += Math.max(maxGraph[i - 1][1], maxGraph[i - 1][2]);
                minGraph[i][0] += Math.min(minGraph[i - 1][0], minGraph[i - 1][1]);
                minGraph[i][1] += Math.min(Math.min(minGraph[i - 1][0], minGraph[i - 1][1]), minGraph[i - 1][2]);
                minGraph[i][2] += Math.min(minGraph[i - 1][1], minGraph[i - 1][2]);
            }
        }

        System.out.println(Math.max(Math.max(maxGraph[n - 1][0], maxGraph[n - 1][1]), maxGraph[n - 1][2]) + " " + Math.min(Math.min(minGraph[n - 1][0], minGraph[n - 1][1]), minGraph[n - 1][2]));
    }
}