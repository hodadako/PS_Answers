class Solution {
    String answer = "";
    char[] orders = {'d', 'l', 'r', 'u'};
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    int N, M, sx, sy, ex, ey, total; 
    boolean[][][] visited = new boolean[50][50][2500];
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        sx = x - 1;
        sy = y - 1;
        ex = r - 1;
        ey = c - 1;
        total = k;
        
        dfs(new StringBuilder(), sx, sy, 0);
        
        return answer.equals("") ? "impossible" : answer;
    }
    
    void dfs(StringBuilder path, int x, int y, int step) {
        if (step == total) {
            if (x == ex && y == ey) {
                String result = path.toString();
                if (answer.equals("") || answer.compareTo(result) > 0) answer = result;
            }
            return;
        }
        
        int dist = Math.abs(x - ex) + Math.abs(y - ey);
        int remainder = total - step;
        if (dist > remainder || dist % 2 != remainder % 2) return;
        

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (visited[nx][ny][step]) continue;
            visited[nx][ny][step] = true;
            path.append(orders[i]);
            dfs(path, nx, ny, step + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}