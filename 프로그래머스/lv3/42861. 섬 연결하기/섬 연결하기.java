import java.util.Arrays;

class Solution {
    public int[] parent = new int[102]; 
    
    int find_parent(int x) {
        if (parent[x] != x) {
            parent[x] = find_parent(parent[x]);
        }
        return parent[x];
    }
    
    void union_parent(int a, int b) {
        a = find_parent(a);
        b = find_parent(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
     
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int bridges = n - 1;
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2) -> {
            return o1[2] - o2[2]; 
        });
        
        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int cost = costs[i][2];
            if (find_parent(a) != find_parent(b)) {
                union_parent(a, b);
                answer += cost;
            } 
        }
        return answer;
    }
}