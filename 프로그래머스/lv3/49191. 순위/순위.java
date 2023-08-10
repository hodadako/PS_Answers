import java.util.*;

class Solution {
    int[][] graph;
    
    private void dfs(int k, ArrayList<ArrayList<Integer>> lose) {
        boolean[] visited = new boolean[lose.size()];
        LinkedList<Integer> q = new LinkedList<>();
        q.add(k);
        while (!q.isEmpty()) {
            ArrayList<Integer> temp = lose.get(q.removeFirst());
            // System.out.println(temp);
            for (int i : temp) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);       
                }
            }
        }
        
        for (int i = 1; i < visited.length; i++) {
            if (visited[i]) {
                graph[k][i] = 1;
            }
        }
    }
    
    public int solution(int n, int[][] results) {
        ArrayList<ArrayList<Integer>> win = new ArrayList<>();
        ArrayList<ArrayList<Integer>> lose = new ArrayList<>();
        graph = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            win.add(new ArrayList<>());
            lose.add(new ArrayList<>());
        }
        
        for (int[] result : results) {
            lose.get(result[1]).add(result[0]);
            win.get(result[0]).add(result[1]);
        }
        
        for (int i = 1; i < n + 1; i++) {
            dfs(i, lose);
            dfs(i, win);
        }

        // for (int i = 1; i < n + 1; i++) {
        //     for (int j = 1; j < n + 1; j++) {
        //         System.out.print(graph[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        int answer = 0;
        
        for (int i = 1; i < n + 1; i++) {
            int total = 0;
            for (int j = 1; j < n + 1; j++) {
                total += graph[i][j];
            }
            
            if (total == n - 1) {
                answer++;
            }
        }
        return answer;
    }
}