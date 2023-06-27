class Solution {
    private long[] dp = new long[100001];
    
    public int solution(int n) {
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < 100001; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1234567;
        }
        return (int) dp[n];
    }
}