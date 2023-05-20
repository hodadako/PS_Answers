class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        String[][] result = new String[my_string.length() / m][m];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = String.valueOf(my_string.charAt(i * m + j));
                if (j == c - 1) {
                    answer += result[i][j];
                }
            }   
        }
        return answer;
    }
}