import java.util.*;

class Solution {
    class Node {
        int y;
        int count;
        
        public Node(int y, int count) {
            this.y = y;
            this.count = count;
        }
        
        public int getY() {
            return this.y;
        }
        
        public int getCount() {
            return this.count;
        }
    }
    
    private boolean[] visited = new boolean[1000001];
    private int bfs(int x, int y, int n) {
        int count = 0;
        if (y == x) {;
            return count;
        } 
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(y, count));
        while(!q.isEmpty()) {
            Node node = q.removeFirst();
            int a = node.getY();
            int cur = node.getCount();
            if (x <= a - n && !visited[a - n]) {
                if (x == a - n) {
                    return cur + 1;
                } 
                visited[a - n] = true;
                q.add(new Node(a - n, cur + 1));
            }
            
            if (a % 2 == 0 && x <= a / 2 && !visited[a / 2]) {
                if (x == a / 2) {
                    return cur + 1;
                }
                visited[a / 2] = true;
                q.add(new Node(a / 2, cur + 1));
            }
            
            if (a % 3 == 0 && x <= a / 3 && !visited[a / 3]) {
                if (x == a / 3) {
                    return cur + 1;
                }
                visited[a / 3] = true;
                q.add(new Node(a / 3, cur + 1));
            }
        } return -1;
    }
    
    public int solution(int x, int y, int n) {
        int count = bfs(x, y, n);
        return count;
    }
}