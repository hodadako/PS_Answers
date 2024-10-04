import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] graph;
    static int H, W;
    static int answer = 0;
    
    static class Node {
        int x, y, count;
        
        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        
        graph = new char[H][W];
        
        for (int i = 0; i < H; i++) {
            String line = sc.next();
            for (int j = 0; j < W; j++) {
                graph[i][j] = line.charAt(j);
            }
        }
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (graph[i][j] == 'L') {
                    bfs(i, j, new boolean[H][W]);
                }
            }
        }
        
        System.out.println(answer);
    }
    
    private static void bfs(int x, int y, boolean[][] visited) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 0));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Node next = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= H || ny >= W) {
                    continue;
                }
                
                if (visited[nx][ny]) {
                    continue;
                }
                
                if (graph[nx][ny] == 'L') {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, next.count + 1));
                    answer = Math.max(answer, next.count + 1);
                }
            }
        }
    }
}
