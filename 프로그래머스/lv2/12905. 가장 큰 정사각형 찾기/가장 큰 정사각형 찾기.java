class Solution {
    private int[][] map = new int[1000][1000];
    private int answer = 0;
    
    private void init(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                map[i][j] = board[i][j];
            }
        }
    }
   
    private void check(int x, int y) {
        if (map[x][y] >= 1) {
            if (map[x - 1][y - 1] >= 1 && map[x - 1][y] >= 1 && map[x][y - 1] >= 1) {
                map[x][y] = Math.min(Math.min(map[x - 1][y - 1] , map[x - 1][y]), map[x][y - 1]) + 1;
            }
            answer = Math.max(answer, map[x][y]);
        }
    }
    
    public int solution(int[][] board){
        init(board);
        int n = board.length;
        int m = board[0].length;
        if (n == 1 && m == 1) {
            answer = 1; 
        } else {
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    check(i, j);
                }
            }
        }

        return answer * answer;
    }
}