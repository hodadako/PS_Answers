import java.util.*;

class Solution {
    int bfs(int a, int b, int m, int n, int time, int[][] picture, int[][] visited) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        LinkedList<int[]> q = new LinkedList<>();
        int[] temp = {a, b};
        q.add(temp);
        int count = 1;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            int current = picture[x][y];
            visited[x][y] = time;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (picture[nx][ny] == current && visited[nx][ny] == 0) {
                        int[] temp2 = {nx, ny}; 
                        q.add(temp2);
                        visited[nx][ny] = time;
                        count += 1;
                    }
                }
            }
        }
        return count;
    }

    public int[] solution(int m, int n, int[][] picture) {
        int[][] visited = new int[m][n];
        int[] answer = new int[2];
        int time = 1;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && visited[i][j] == 0) {
                    count = bfs(i, j, m, n, time, picture, visited);
                    if (count > answer[1]) {
                        answer[1] = count;
                    }
                    time += 1;
                }
            }
        }
        time -= 1;
        answer[0] = time;
        return answer;
    }
}