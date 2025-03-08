import java.util.*;

class Solution {
    final int MAX = 1_000_000;
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    int[] indegree = new int[MAX + 1];
    int[] outdegree = new int[MAX + 1];
    boolean[] visited;
    int start = -1;
    int[] answer;
    
    
    public int[] solution(int[][] edges) {
        visited = new boolean[MAX + 1];
        
        for (int i = 0; i <= 1_000_000; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            outdegree[edge[0]]++;
            indegree[edge[1]]++;
        }
                          
        for (int i = 0; i < graph.size(); i++) {
            if (indegree[i] == 0 && outdegree[i] >= 2) {
                start = i;
            }
        }
        
        answer = new int[]{start, 0, 0, 0};

        for (int i : graph.get(start)) {
            bfs(i);
        }
                          
        return answer;
    }
    
    void bfs(int start) {
        LinkedList<Integer> q = new LinkedList<>();
        int u = 0;
        HashSet<Integer> vertex = new HashSet<>();
        vertex.add(start);
        visited[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int j : graph.get(now)) {
                u++;
                if (!visited[j]) {
                    q.add(j);
                    vertex.add(j);
                    visited[j] = true;
                }
            }
        }
        
        if (vertex.size() == u) {
            answer[1]++;
        } else if (vertex.size() - 1 == u) {
            answer[2]++;
        }  else {
            answer[3]++;
        }
    } 
}
