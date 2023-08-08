class Solution {
    private void print(int m, int n, int[][] graph) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        boolean[][] watered = new boolean[n][m];
        int[][] ways = new int[n][m];
        for (int[] puddle : puddles) {
            watered[puddle[1] - 1][puddle[0] - 1] = true;
        }
        if (n > 1 && m > 1) {
            for (int i = 0; i < m; i++) {
                if (!watered[0][i]) {
                    ways[0][i] = 1;
                } else {
                    break;
                }
            }

            for (int i = 0; i < n; i++) {
                if (!watered[i][0]) {
                    ways[i][0] = 1;
                } else {
                    break;
                }
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) { 
                    if (watered[i][j]) {
                        continue;
                    } else {
                        if (!watered[i - 1][j]) {
                            ways[i][j] += ways[i - 1][j];
                        } 
                        if (!watered[i][j - 1]) {
                            ways[i][j] += ways[i][j - 1];
                        }
                        ways[i][j] %= 1_000_000_007;
                    }
                }
            }
            // print(m, n, ways);
            
            answer = ways[n - 1][m - 1];
        } else if (n == 1 || m == 1) {
            if (puddles.length == 0) {
                answer = 1;
            }
        }
        return answer % 1_000_000_007;
    }
}