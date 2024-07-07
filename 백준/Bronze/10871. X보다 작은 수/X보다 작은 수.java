import java.io.*;
import java.util.*;

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
    
    static int n, k;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {
        FastReader fr = new FastReader(); 
        
        n = fr.nextInt();
        k = fr.nextInt();
        
        for (int i = 0; i < n; i++) {
            int now = fr.nextInt();
            if (now < k) {
                sb.append(now + " ");
            }
        }
        
        System.out.println(sb.toString());
    }
}