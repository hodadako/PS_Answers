class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    int n, m;
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        n = board.length;
        m = board[0].length;
        Result r = dfs(board, aloc[0], aloc[1], bloc[0], bloc[1], true);
        return r.count;
    }
    
    class Result {
        boolean win;
        int count;
        public Result(boolean w, int c) {
            this.win = w;
            this.count = c;
        } 
    }
    
    public Result dfs(int[][] board, int x1, int y1, int x2, int y2, boolean turn) {
        int x = turn ? x1 : x2;
        int y = turn ? y1 : y2;
        if (board[x][y] == 0) return new Result(false, 0);
        
        boolean canMove = false;
        boolean win = false;
        int minWin = Integer.MAX_VALUE;
        int maxLose = 0;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m || board[nx][ny] == 0) continue;
            
            canMove = true;
            board[x][y] = 0;
            Result next;
            if (turn) {
                next = dfs(board, nx, ny, x2, y2, false);
            } else {
                next = dfs(board, x1, y1, nx, ny, true);
            }
            
            board[x][y] = 1;
            
            if (!next.win) {
                win = true;
                minWin = Math.min(minWin, next.count + 1);
            } else if (!win){
                maxLose = Math.max(maxLose, next.count + 1);
            }
        }
        
        if (!canMove) return new Result(false, 0);
        if (win) return new Result(true, minWin);
        return new Result(false, maxLose);
    }
}