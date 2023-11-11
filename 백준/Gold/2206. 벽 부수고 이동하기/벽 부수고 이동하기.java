import java.util.*;
import java.io.*;

class Main {
    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static int a, b;
    static final int INF = (int) 1e9;
    static int[][] graph;
    static int[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Node {
        int x, y, dist, cons;

        public Node(int x, int y, int dist, int cons) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.cons = cons;
        }
    }

    private static int bfs(int x, int y) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 1, 0));
        visited[x][y] = 0;
        while (!q.isEmpty()) {
            Node now = q.removeFirst();
            if (now.x == a - 1 && now.y == b - 1) {
                return now.dist;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i], ny = now.y + dy[i];
                if (nx < 0 || nx >= a || ny < 0 || ny >= b) continue;
                if (visited[nx][ny] > now.cons) {
                    if (graph[nx][ny] == 0) {
                        visited[nx][ny] = now.cons;
                        q.add(new Node(nx, ny, now.dist + 1, now.cons));
                    } else if (graph[nx][ny] == 1 && now.cons == 0) {
                        visited[nx][ny] = now.cons + 1;
                        q.add(new Node(nx, ny, now.dist + 1, now.cons + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        a = sc.nextInt();
        b = sc.nextInt();
        graph = new int[a][b];
        visited = new int[a][b];
        for (int i = 0; i < a; i++) {
            String now = sc.next();
            for (int j = 0; j < b; j++) {
                graph[i][j] = Character.getNumericValue(now.charAt(j));
                visited[i][j] = INF;
            }
        }

        System.out.println(bfs(0, 0));
    }
}