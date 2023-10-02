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
        String s = sc.next();
        int[] abcArr = new int[26];
        String abc = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < abc.length(); j++) {
                if (s.charAt(i) == abc.charAt(j)) {
                    abcArr[j]++;
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(abcArr[i] + " ");
        }
    }
}