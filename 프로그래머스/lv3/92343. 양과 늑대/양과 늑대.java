import java.util.*;

class Solution {
    int[] left = new int[20];
    int[] right = new int[20];
    int[] val = new int[20];
    int n;
    int answer = 1;
    int[] vis = new int[1<<17];
    
    void solve(int state) {
        if(vis[state] == 1) return;
        vis[state] = 1;
        int wolf = 0, num = 0;
        for (int i = 0; i < n; i++) {
            if ((state & (1 << i)) != 0) {
                num++;
                wolf+=val[i];
            }
        }
        
        if (2 * wolf >= num) return;
        answer = Math.max(answer, num-wolf);
        for (int i = 0; i < n; i++) {
            if ((state & (1 << i)) == 0) continue;
            if (left[i] != -1) solve(state | (1<<left[i]));
            if (right[i] != -1) solve(state | (1<<right[i]));
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        // System.out.println(Arrays.toString(vis));
        n = info.length;
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        for (int i = 0; i < n; i++) val[i] = info[i];
        for (int[] edge : edges) {
            if (left[edge[0]] == -1) left[edge[0]] = edge[1];
            else right[edge[0]] = edge[1];
        }
        solve(1);
        return answer;
    }
}