import java.util.*;

class Solution {
    class Node {
        int x;
        int y;
        int count;
        
        Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
        
        public int getX() {
            return this.x;
        } 
        
        public int getY() {
            return this.y;
        }
        
        public int getCount() {
            return this.count;
        }
    }
    
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, -1, 0, 1};  
    
    private int bfs(int[][] maps, int a, int b, int count) {
        int n = maps.length;
        int m = maps[0].length;
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(a, b, count));
        while (!q.isEmpty()) {
            Node node = q.removeFirst();
            int x = node.getX();
            int y = node.getY();
            int cur = node.getCount();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (maps[nx][ny] == 0) continue;
                    if (maps[nx][ny] == 1) {
                        maps[nx][ny] = cur + 1;
                        q.add(new Node(nx, ny, cur + 1)); 
                    }
                }
            }
        }
        
        return maps[n - 1][m - 1];
    }
    
    public int solution(int[][] maps) {
        int answer = bfs(maps, 0, 0, 1);
        return answer > 1 ? answer : -1;
    }
}