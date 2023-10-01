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
        String a = sc.next();
        String b = sc.next();
        char[] arr1 = new char[a.length() + 1];
        char[] arr2 = new char[b.length() + 1];

        for (int i = 1; i < a.length() + 1; i++) {
            arr1[i] = a.charAt(i - 1);
        }
        for (int i = 1; i < b.length() + 1; i++) {
            arr2[i] = b.charAt(i - 1);
        }
        int[][] lcs = new int[a.length() + 1][b.length() + 1];
        int answer = 0;
        for (int i = 0; i < a.length() + 1; i++) {
            for (int j = 0; j < b.length() + 1; j++) {
                if (i == 0 || j == 0) {
                    lcs[i][j] = 0;
                } else if (arr1[i] == arr2[j]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        for (int i = 0; i < a.length() + 1; i++) {
            for (int j = 0; j < b.length() + 1; j++) {
                answer = Math.max(answer, lcs[i][j]);
            }
        }

        System.out.println(answer);
    }
}