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
    
    static int[][][] dp;
    static final int modular = (int)1e9;
    static final int bitField = 1 << 10;
    
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        
        dp = new int[n + 1][10][bitField];
        
        for (int i = 0; i < 10; i++) {
            dp[1][i][1 << i] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < bitField; k++) {
                    if (j != 9) {
                        dp[i + 1][j + 1][k | 1 << (j + 1)] += dp[i][j][k];
                        dp[i + 1][j + 1][k | 1 << (j + 1)] %= modular;
                    } 
                    if (j != 0) {
                        dp[i + 1][j - 1][k | 1 << (j - 1)] += dp[i][j][k];
                        dp[i + 1][j - 1][k | 1 << (j - 1)] %= modular;
                    }
                } 
            }
        }
        
        int answer = 0;
        for (int i = 1; i < 10; i++) {
            answer = (answer + dp[n][i][bitField - 1]) % modular;
        }
        System.out.println(answer);
    }
}
