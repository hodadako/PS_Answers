import java.util.*;
import java.io.*;
import java.math.BigInteger;

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
    
    static int TC;
    static BigInteger[][][] dp = new BigInteger[21][21][21];
    
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        TC = fr.nextInt();
        StringBuilder sb = new StringBuilder();
            
        init();
        
        for (int i = 0; i < TC; i++) {
            int n = fr.nextInt();
            int l = fr.nextInt();
            int r = fr.nextInt();
            sb.append(dp[n][l][r] + "\n");
        }
        System.out.print(sb);
    }
    
    static void init() {
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                Arrays.fill(dp[i][j], BigInteger.ZERO);
            }
        }
        
        dp[1][1][1] = BigInteger.ONE;
        
        for (int n = 2; n < 21; n++) {
            for (int l = 1; l < 21; l++) {
                for (int r = 1; r < 21; r++) {
                    dp[n][l][r] = dp[n][l][r].add(dp[n - 1][l - 1][r]).add(dp[n - 1][l][r - 1]).add(dp[n - 1][l][r].multiply(new BigInteger(String.valueOf(n - 2))));
                }
            }
        }
    }
}
