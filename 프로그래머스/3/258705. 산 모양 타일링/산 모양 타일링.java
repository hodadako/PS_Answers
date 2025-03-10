class Solution {
    int mod = 10007;
    int[][] dp = new int[100001][2];
    public int solution(int n, int[] tops) {
        dp[1][0] = 1;
        dp[1][1] = tops[0] == 0 ? 2 : 3; 
        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                if (tops[i - 1] == 0) {
                    dp[i][1] = (dp[i - 1][1] * 2 + dp[i - 1][0]) % mod;
                    dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
                } else {
                    dp[i][1] = (dp[i - 1][1] * 3 + dp[i - 1][0] * 2) % mod;
                    dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
                }
            }
        }
        return (dp[n][1] + dp[n][0]) % mod;
    }
}