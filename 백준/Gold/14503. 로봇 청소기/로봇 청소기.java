import java.io.*;
import java.util.*;

class Main {
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
        int x, y, dir, tries;

        public Node(int x, int y, int dir, int tries) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.tries = tries;
        }
    }

    static int[][] graph;
    static int[][] print;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static int moveBack(int dir) {
        dir += 2;
        dir %= 4;
        return dir;
    }

    private static int turnLeft(int dir) {
        dir += 3;
        dir %= 4;
        return dir;
    }

    private static void bfs(int r, int c, int d, int n, int m) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(r, c, d, 1));
        visited[r][c] = true;
        print[r][c] = 1;
        while (!q.isEmpty()) {
            Node node = q.removeFirst();
            int nextDir = node.dir;
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i], ny = node.y + dy[i];
                if (graph[nx][ny] == 0 && !visited[nx][ny]) {
                    count++;
                }
            }

            if (count == 0) {
//                System.out.println(node.dir);
//                System.out.println(moveBack(node.dir));
//                System.out.println("x = " + node.x + " y = " + node.y);
                int backDir = moveBack(node.dir);
                int nx = node.x + dx[backDir], ny = node.y + dy[backDir];
                if (graph[nx][ny] == 0) {
                    q.add(new Node(nx, ny, node.dir, node.tries + 1));
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    nextDir = turnLeft(nextDir);
                    int nx = node.x + dx[nextDir], ny = node.y + dy[nextDir];
                    if (graph[nx][ny] == 0 && !visited[nx][ny]) {
                        q.add(new Node(nx, ny, nextDir, node.tries + 1));
                        visited[nx][ny] = true;
                        print[nx][ny] = node.tries + 1;
                        break;
                    }
                }
            }

//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    System.out.print(print[i][j] + "   ");
//                }
//                System.out.println();
//            }
//
//            System.out.println("____________________________________________________________");
        }
    }


    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt(), m = sc.nextInt();
        graph = new int[n][m];
        visited = new boolean[n][m];
        print = new int[n][m];
        int r = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] == 1) {
                    print[i][j] = -1;
                }
            }
        }

        bfs(r, c, d, n, m);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    answer++;
                }
//                System.out.print(visited[i][j] + " ");
            }
//            System.out.println();
        }
//
//        for (int i = 0; i < 4; i++) {
//            System.out.println(i + " " + turnLeft(i));
//            System.out.println(i + " " + moveBack(i));
//        }

        System.out.println(answer);
    }
}