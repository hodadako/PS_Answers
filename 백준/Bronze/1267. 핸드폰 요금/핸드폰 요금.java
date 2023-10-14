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
        int y = 0, m = 0;
        for (int i = 0; i < n; i++) {
            int now = sc.nextInt() + 1;
            y += (now / 30 + (now % 30 > 0 ? 1 : 0)) * 10;
            m += (now / 60 + (now % 60 > 0 ? 1 : 0)) * 15;
        }

        if (y == m) {
            System.out.println("Y" + " M " + y);
        } else if (y > m) {
            System.out.println("M " + m);
        } else {
            System.out.println("Y " + y);
        }
    }
}