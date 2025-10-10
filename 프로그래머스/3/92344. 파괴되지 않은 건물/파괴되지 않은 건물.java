class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] sum = new int[n + 1][m + 1];
        for (int[] shot : skill) {
            int degree = shot[5];
            int x1 = shot[1], y1 = shot[2], x2 = shot[3], y2 = shot[4];
            if (shot[0] == 1) degree = -degree;
            sum[x1][y1] += degree;
            sum[x1][y2 + 1] -= degree;
            sum[x2 + 1][y1] -= degree;
            sum[x2 + 1][y2 + 1] += degree;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m + 1; j++) {
                sum[i][j] += sum[i][j - 1];
            } 
        }
        
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n + 1; i++) {
                sum[i][j] += sum[i - 1][j];
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] + sum[i][j]> 0) {
                    answer++;
                }
            }
        }
        // print(board);
        return answer;
    }
    
    private void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}