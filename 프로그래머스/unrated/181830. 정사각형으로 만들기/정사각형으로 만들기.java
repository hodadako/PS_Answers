class Solution {
    public int[][] solution(int[][] arr) {
        int[][] answer = {};
        int n = arr.length, m = arr[0].length;
        if (n > m) {
            answer = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer[i][j] = arr[i][j];
                }
            }
        } else if (n == m) {
            answer = arr;
        } else {
            answer = new int[m][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer[i][j] = arr[i][j];
                }
            }
        }
        return answer;
    }
}