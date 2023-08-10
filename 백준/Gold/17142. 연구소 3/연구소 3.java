import java.util.*;
import java.io.*;

class Main {
    static boolean[][] visited;
    static boolean[][] virus;
    static boolean[][] control;
    static int[][] graph;
    static ArrayList<Node> dots = new ArrayList<>();
    static ArrayList<ArrayList<Node>> cur = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    static class FastReader {
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

    static class Node {
        int x, y, timeA, timeB, type;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int timeA, int timeB, int type) {
            this.x = x;
            this.y = y;
            this.timeA = timeA;
            this.timeB = timeB;
            this.type = type;
        }
    }

    public static void combination(ArrayList<Node> list, int count, int index) {
        if (count == 0) {
            cur.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < dots.size(); i++) {
            list.add(dots.get(i));
            combination(list, count - 1, i + 1);
            list.remove(list.size() - 1);
        }
    }

    private static void bfs(int n, ArrayList<Node> nodes) {
        int[][] map = new int[n][n];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        LinkedList<Node> q = new LinkedList<>();
        for (int i = 0; i < nodes.size(); i++) {
            Node curNode = nodes.get(i);
            q.add(new Node(curNode.x, curNode.y, curNode.timeA, curNode.timeB, curNode.type));
            visited[curNode.x][curNode.y] = true;
            map[curNode.x][curNode.y] = curNode.timeA;
        }
        int count = 0;
        while (!q.isEmpty()) {
            Node node = q.removeFirst();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i], ny = node.y + dy[i];
                if (nx < 0 || nx >= n | ny < 0 || ny >= n) continue;
                if (graph[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    map[nx][ny] = node.timeA + 1;
                    q.add(new Node(nx, ny, node.timeA + 1, node.timeB + 1, 0));
                }
                if (graph[nx][ny] == 2 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    map[nx][ny] = node.timeB;
                    q.add(new Node(nx, ny, node.timeA + 1, node.timeB, 2));
                }
            }
        }
        if (count == 5) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == control[i][j]) {
                    count = Math.max(count, map[i][j]);
                } else {
                    if (!virus[i][j]) {
                        return;
                    }
                }
            }
        }

        answer = Math.min(answer, count);
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int n = sc.nextInt(), m = sc.nextInt();
        graph = new int[n][n];
        control = new boolean[n][n];
        virus = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] == 2) {
                    dots.add(new Node(i, j, 0, 0, 2));
                    control[i][j] = true;
                    virus[i][j] = true;
                }
                if (graph[i][j] == 0) {
                    control[i][j] = true;
                }
            }
        }

        combination(new ArrayList<>(), m, 0);

        for (int i = 0; i < cur.size(); i++) {
            visited = new boolean[n][n];
            bfs(n, cur.get(i));
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}