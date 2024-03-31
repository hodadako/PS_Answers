import java.util.*;

class Solution {
    boolean[][] visited;
    int[][] arr;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    int width, height;
    int oilNumber = 0;
    int answer = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    
    public int solution(int[][] land) {
        init(land);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                bfs(i, j);
            }
        }
        solve();
        // System.out.println(map); 
        return answer;
    }
    
    public void solve() {
        for (int i = 0; i < width; i++) {
            if (map.containsKey(i)) {
                answer = Math.max(answer, map.get(i));
            }
        }
    }
    
    public void init(int[][] land) {
        width = land[0].length;
        height = land.length;
        
        arr = land;
        visited = new boolean[height][width];
    }
    
    public void bfs(int x, int y) {
        if (visited[x][y] || arr[x][y] == 0) return;
        oilNumber++;
        LinkedList<Node> q = new LinkedList<>();
        HashSet<Node> list = new HashSet<>();
        Node start = new Node(x, y);
        list.add(start);
        q.add(start);
        visited[x][y] = true;
        int count = 1;
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx >= height || ny < 0 || ny >= width) continue;
                if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                    Node next = new Node(nx, ny);
                    q.add(next);
                    list.add(next);
                    count++;
                    visited[nx][ny] = true;
                }
            }
        }
        
        // System.out.println("oil size is " + list);
        
        for (Node oil : list) {
            map.put(oil.y, map.getOrDefault(oil.y, 0) + count);
        }
    }
    
    class Node {
        int x, y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int hashCode() {
            return ("," + y).hashCode();
        }
        
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Node)) return false;
            Node other = (Node) o;
            return this.y == other.y;
        }
    }
    
    class Oil {
        int number, total;
        
        public Oil(int number, int total) {
            this.number = number;
            this.total = total;
        }
        
        @Override
        public int hashCode() {
            return (number + "," + total).hashCode();
        }
        
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Oil)) return false;
            Oil other = (Oil) o;
            return this.number == other.number;
        }
        
        public int getTotal() {
            return this.total;
        }
    }
}