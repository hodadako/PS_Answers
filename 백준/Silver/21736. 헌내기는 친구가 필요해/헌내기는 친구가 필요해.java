import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int bfs(int x, int y, char[][] graph, boolean[][] visited) {
        int n = graph.length, m = graph[0].length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int result = 0;
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Node node = q.removeFirst();
            int a = node.x, b = node.y;
            for (int i = 0; i < 4; i++) {
                int nx = a + dx[i], ny = b + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (graph[nx][ny] == 'O' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                } else if (graph[nx][ny] == 'P' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sx = 0, sy = 0;
        int n = sc.nextInt(), m = sc.nextInt();
        char[][] graph = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String cur = sc.next();
            for (int j = 0; j < m; j++) {
                graph[i][j] = cur.charAt(j);
                if (graph[i][j] == 'I') {
                    sx = i;
                    sy = j;
                }
            }
        }

        int answer = bfs(sx, sy, graph, visited);
        System.out.println(answer > 0 ? answer : "TT");
    }
}

