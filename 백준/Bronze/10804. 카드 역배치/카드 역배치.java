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
    static int[] cards = new int[20];

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        for (int i = 0; i < 20; i++) {
            cards[i] = i + 1;
        }

        for (int i = 0; i < 10; i++) {
            int start = fr.nextInt() - 1, end = fr.nextInt() - 1;
            for (int j = start; j <= (start + end) / 2 ; j++) {
                int temp = cards[j];
                cards[j] = cards[end - (j - start)];
                cards[end - (j - start)] = temp;
            }
        }

        for (int i = 0; i < 20; i++) {
            System.out.print(cards[i] + " ");
        }
    }
}