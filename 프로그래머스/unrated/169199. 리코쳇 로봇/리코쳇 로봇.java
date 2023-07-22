import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] minDist;
    static char[][] graph;
    static boolean[][] visited;
    static int sx, sy, ex, ey, n, m;

    static class Node {
        int x, y, dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    private static void init(String[] board) {
        n = board.length;
        m = board[0].length();
        minDist = new int[n][m];
        graph = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = board[i].charAt(j);
                if (graph[i][j] == 'R') {
                    sx = i;
                    sy = j;
                } else if (graph[i][j] == 'G') {
                    ex = i;
                    ey = j;
                }
                minDist[i][j] = -1;
            }
        }
    }

    private static void bfs(int x, int y, int dist) {
        LinkedList<Node> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Node(x, y, dist));
        while (!q.isEmpty()) {
            Node node = q.removeFirst();
            int a = node.x, b = node.y, cur = node.dist;
            for (int i = 0; i < 4; i++) {
                int nx = a , ny = b, nc = cur + 1;
                for (int j = 0; j < Math.max(n, m); j++) {
                    nx += dx[i];
                    ny += dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (graph[nx][ny] == 'D') {
                            nx -= dx[i];
                            ny -= dy[i];
                            break;
                        }
                    }
                }
                // System.out.println("nx = " + nx + " ny = " + ny + " cur = " + cur );
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {

                    if (minDist[nx][ny] > 0) {
                        minDist[nx][ny] = Math.min(minDist[nx][ny], nc);
                    } else {
                        minDist[nx][ny] = nc;
                    }
                    if (!visited[nx][ny]) {
                        q.add(new Node(nx, ny, nc));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(minDist[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int solution(String[] board) {
        init(board);
        // System.out.println("sx = " + sx + " sy = " + sy + " ex = " + ex + " ey = " + ey);
        bfs(sx, sy, 0);
        // print();
        return minDist[ex][ey];
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
    }
}