import java.util.*;

class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    boolean[][] visited;
    char[][] arr;
    int n, m;
    ArrayList<Integer> islands = new ArrayList<>();
    
    class Node {
        int x, y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private void bfs(int x, int y) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;
        int total = Character.getNumericValue(arr[x][y]);
        while (!q.isEmpty()) {
            Node node = q.removeFirst();
            for (int i = 0; i < 4; i++) { 
                int nx = node.x + dx[i], ny = node.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (arr[nx][ny] == 'X') continue;
                    if (arr[nx][ny] != 'X' && !visited[nx][ny]) {
                        visited[nx][ny] = true; 
                        total += Character.getNumericValue(arr[nx][ny]);
                        q.add(new Node(nx, ny));
                    }
                }
            }
        }
        
        islands.add(total);
    }
    
    private void init(String[] maps) {
        arr = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = maps[i].charAt(j);
            }
        }
    }
    
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        init(maps);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && arr[i][j] != 'X') {
                    bfs(i, j); 
                }
            }
        }
        
        Collections.sort(islands); 
        
        return islands.isEmpty() ? new int[]{-1} : islands.stream().mapToInt(Integer::intValue).toArray();
    }
}