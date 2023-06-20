class Solution {
    private long[] dp = new long[60001];
    
    public int solution(int n) {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        
        for (int i = 4; i < 60001; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000_007;
        }
        
        int answer = (int) dp[n];
        return answer;
    }
}