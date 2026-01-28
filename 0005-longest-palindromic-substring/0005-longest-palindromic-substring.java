class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String answer = "";
        for (int i = 0; i < n; i++) {
            int start = i;
            int end = i;
            for (int j = 1; j < n; j++) {
                if (i - j < 0 || i + j >= n) {
                    break;
                }
                if (s.charAt(i - j) != s.charAt(i + j)) break;
                start = i - j;
                end = i + j;
            }

            if (answer.length() <= end - start + 1) {
                answer = s.substring(start, end + 1);
            }

            start = i;
            end = i + 1;
            
            if (end < n && s.charAt(start) == s.charAt(end)) {
                for (int j = 1; j < n; j++) {
                    if (i - j < 0 || i + 1 + j >= n) {
                        break;
                    }
                if (s.charAt(i - j) != s.charAt(i + 1 + j)) break;
                    start = i - j;
                    end = i + 1 + j;
                }
                            
                if (answer.length() <= end - start + 1) {
                    answer = s.substring(start, end + 1);
                }
            }

            start = i - 1;
            end = i;

            if (start > 0 && s.charAt(start) == s.charAt(end)) {
                for (int j = 1; j < n; j++) {
                    if (i - 1 - j < 0 || i + j >= n) {
                        break;
                    }
                if (s.charAt(i - 1 - j) != s.charAt(i + j)) break;
                    start = i - 1 - j;
                    end = i + j;
                }

                if (answer.length() <= end - start + 1) {
                    answer = s.substring(start, end + 1);
                }
            }
        }
        return answer;
    }
}