class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;
        for (int j = 2; j < m + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                char a = s.charAt(i - 1);
                char b = p.charAt(j - 1);

                if (b == '.' || a == b) {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                if (b == '*') {
                    char prev = p.charAt(j - 2);

                    dp[i][j] = dp[i][j - 2];
                    
                    if (prev == '.' || prev == a) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n][m];
    }
}