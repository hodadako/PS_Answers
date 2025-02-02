import java.util.*;
import java.io.*;

public class Main {
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
        FastReader fr = new FastReader();
        HashSet<Integer> set = new HashSet<>();
        StringBuilder result = new StringBuilder();
        
        int N = fr.nextInt();
        for (int i = 0; i < N; i++) {
            set.add(fr.nextInt());
        }
        
        int M = fr.nextInt();
        for (int i = 0; i < M; i++) {
            int now = fr.nextInt();
            result.append(set.contains(now) ? 1 : 0);
            if (i != M - 1) {
                result.append(" ");
            } 
        }
        System.out.print(result);
    }
}
