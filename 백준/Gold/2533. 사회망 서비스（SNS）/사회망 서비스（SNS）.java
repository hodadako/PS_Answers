import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[][] dp = new int[1_000_001][2];
    static boolean[] visited = new boolean[1_000_001];
    static void dfs(int i) {
        visited[i] = true;
        dp[i][0] = 0;
        dp[i][1] = 1;
        
        for (int child : graph.get(i)) {
            if (!visited[child]) {
                dfs(child);
                dp[i][0] += dp[child][1];
                dp[i][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
}
