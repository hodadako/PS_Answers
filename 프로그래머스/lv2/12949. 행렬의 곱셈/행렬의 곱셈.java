class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int height = arr1.length; 
        int width = arr2[0].length;
        int[][] answer = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int cur = 0;
                for (int k = 0; k < arr1[0].length; k++) {
                    cur += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = cur; 
            }
        }
        return answer;
    }
}