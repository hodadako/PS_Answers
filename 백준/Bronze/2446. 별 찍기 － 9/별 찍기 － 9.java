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
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        for (int i = 1; i <= n ; i++) {
            for (int j = 0; j < i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (n - i + 1) * 2 - 1; j++) {
                System.out.print("*");
            }
            if (i != n) {
                System.out.println();
            }
        }
        if (n >= 2) {
            System.out.println();
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < n - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < (i) * 2 - 1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}