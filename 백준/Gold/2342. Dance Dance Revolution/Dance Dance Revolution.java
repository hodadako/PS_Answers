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
    static final int INF = (int)1e9;
    
    static int calc(int start, int end) {
        if (start == 0) {
            return 2;
        } else if (Math.abs(start - end) == 2) {
            return 4;
        } else if (start == end) {
            return 1;
        }
        return 3;
    }
    
    static class Step {
        int x, y, index;
        
        public Step(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int answer = INF;
        ArrayList<Integer> list = new ArrayList<>();
            
        while (true) {
            int now = fr.nextInt();
            if (now == 0) break;
            list.add(now);
        }
        
        dp = new int[list.size() + 1][5][5];
        for (int i = 0; i < list.size() + 1; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }
        
        LinkedList<Step> q = new LinkedList<>();
        dp[0][0][0] = 0;
        for (int i = 0; i < list.size(); i++) {
            int input = list.get(i);
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (dp[i][j][k] == INF) {
                        continue;
                    } 
                    
                    int powerPrev = 0;
                    if (dp[i][j][k] != INF) {
                        powerPrev = dp[i][j][k];
                    }
                    
                    dp[i + 1][j][input] = Math.min(dp[i + 1][j][input], powerPrev + calc(k, input));
                    dp[i + 1][input][k] = Math.min(dp[i + 1][input][k], powerPrev + calc(j, input));
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                answer = Math.min(dp[list.size()][i][j], answer);
            } 
        }
        
        System.out.println(answer);
    }
}
