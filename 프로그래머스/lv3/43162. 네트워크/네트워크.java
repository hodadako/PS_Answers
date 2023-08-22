import java.util.*;

class Solution {
    boolean[][] visited;
    boolean[] numVis;
    int answer = 0;
    
    private void bfs(int now, int[][] computers) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(now);
        numVis[now] = true;
        while (!q.isEmpty()) {
            int cur = q.removeFirst();
            for (int i = 0; i < computers.length; i++) {
                if (!visited[cur][i] && computers[cur][i] == 1) {
                    q.add(i);
                    numVis[i] = true;
                    visited[cur][i] = true;
                    visited[i][cur] = true;
                }
            }
        }
        answer++;
    }
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n][n];
        numVis = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i][i] = true;
        }
        
        
        for (int i = 0; i < n; i++) {
            if (numVis[i]) continue;
            bfs(i, computers);
        }
        return answer;
    }
}