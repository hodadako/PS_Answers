import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    ArrayList<ArrayList<Integer>> graph;
    
    private void init(int n, int cur, int[][] wires) {
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < wires.length; i++) {
            if (i != cur) {
                int a = wires[i][0], b = wires[i][1];
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
        }
    }
    
    private void solve(int n) {
        boolean[] visited = new boolean[n + 1];
        int count1 = 1, count2 = 1;
        visited[0] = true;
        LinkedList<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        while(!q.isEmpty()) {
            int cur = q.removeFirst();
            for (int i : graph.get(cur)) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    count1++;
                }
            }
        }
        
        int next = 0;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                next = i;
                break;
            }
        }
        
        q.add(next);
        visited[next] = true;
        while(!q.isEmpty()) {
            int cur = q.removeFirst();
            for (int i : graph.get(cur)) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    count2++;
                }
            }
        }
        
        answer = Math.min(Math.abs(count1 - count2), answer);
    }
    public int solution(int n, int[][] wires) {
        for (int i = 0; i < wires.length; i++) {
            init(n, i, wires);
            solve(n);
        }
        return answer;
    }
}