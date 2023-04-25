import java.util.*;

class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

}

public class Main {
    private static final int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    static int[][] bfs(int n, int cur_x, int cur_y, int[][] graph, int size) {
        int dist[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = -1;
            }
        }
        LinkedList<Node> q = new LinkedList<Node>();
        q.add(new Node(cur_x, cur_y));
        dist[cur_x][cur_y] = 0;
        while (!q.isEmpty()) {
            Node a = q.removeFirst();
            int x = a.getX(), y = a.getY();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (dist[nx][ny] == -1 && graph[nx][ny] <= size) {
                        dist[nx][ny] = dist[x][y] + 1;
                        q.add(new Node(nx, ny));
                    }
                }
            }
        }
        return dist;
    }

    static int[] find(int n, int[][] dist, int[][] graph, int size) {
        int x = 0, y = 0;
        int min_dist = (int) 1e9;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                if (dist[i][j] != -1 && 1 <= graph[i][j] && graph[i][j] < size ) {
                    if (dist[i][j] < min_dist) {
                        x = i;
                        y = j;
                        min_dist = dist[i][j];
                    }
                }
            }
        }
        int[] answer = new int[3];
        if (min_dist == (int) 1e9) {
            return answer;
        } else {
            answer[0] = x;
            answer[1] = y;
            answer[2] = min_dist;
            return answer;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int size = 2;
        int now_x = 0, now_y = 0;

        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = sc.nextInt();
                graph[i][j] = k;
                if (k == 9) {
                    now_x = i;
                    now_y = j;
                    graph[i][j] = 0;
                }
            }
        }

        int result = 0, ate = 0;

        while (true) {
            int[] value = find(n, bfs(n, now_x, now_y, graph, size), graph, size);
            if (value[0] == 0 && value[1] == 0 && value[2] == 0) {
                System.out.println(result);
                break;
            } else {
                now_x = value[0];
                now_y = value[1];
                result += value[2];
                graph[now_x][now_y] = 0;
                ate += 1;
                if (ate >= size) {
                    size += 1;
                    ate = 0;
                }
            }
        }
    }
}