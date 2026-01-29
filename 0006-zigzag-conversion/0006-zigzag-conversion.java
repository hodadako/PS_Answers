class Solution {
    int[] dx = {1, -1};
    int[] dy = {0, 1};
    public String convert(String s, int numRows) {
        int len = s.length();
        char[][] graph = new char[numRows][len];
        if (numRows == 1) {
            dx[1] = 0;
        }
        int x = 0;
        int y = 0;
        int dir = 0;
        for (int i = 0; i < len; i++) {
            graph[x][y] = s.charAt(i);
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= numRows || ny >= len) {
                dir = 1 - dir;
            }

            x += dx[dir];
            y += dy[dir];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < len; j++) {
                if (graph[i][j] == Character.MIN_VALUE) continue;
                sb.append(graph[i][j]);
            }
        }

        return sb.toString();
    }
}