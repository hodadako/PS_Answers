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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static class Dice {
        int top = 1, now = 6, x, y, dir = 0;
        int[] status = new int[7];
        int[][] next = {{0, 2, 0}, {4, 6, 3}, {0, 5, 0}, {0, 1, 0}};

        void print() {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(next[i][j] + " ");
                }
                System.out.println();
            }
        }

        void uTurn() {
            dir = (dir + 2) % 4;
        }

        void move() {
            int order = dir;
            if (order == 0) {
                right();
            } else if (order == 1) {
                down();
            } else if (order == 2) {
                left();
            } else {
                up();
            }
        }

        void down() {
            int temp = next[0][1];
            for (int i = 0; i < 3; i++) {
                next[i][1] = next[i + 1][1];
            }
            next[3][1] = temp;
            top = next[3][1];
            now = next[1][1];
        }

        void up() {
            int temp = next[3][1];
            for (int i = 3; i > 0; i--) {
                next[i][1] = next[i - 1][1];
            }
            next[0][1] = temp;
            top = next[3][1];
            now = next[1][1];
        }
        void left() {
            int temp = next[1][2];
            for (int i = 2; i > 0; i--) {
                next[1][i] = next[1][i - 1];
            }
            next[1][0] = next[3][1];
            next[3][1] = temp;
            top = next[3][1];
            now = next[1][1];
        }

        void right() {
            int temp = next[1][0];
            for (int i = 0; i < 2; i++) {
                next[1][i] = next[1][i + 1];
            }
            next[1][2] = next[3][1];
            next[3][1] = temp;
            top = next[3][1];
            now = next[1][1];
        }

        public Dice(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void setNextDir() {
            if (now > graph[x][y]) {
                dir++;
                if (dir > 3) {
                    dir = 0;
                }
            } else if (now < graph[x][y]) {
                dir--;
                if (dir < 0) {
                    dir = 3;
                }
            }
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static int bfs(int x, int y) {
        boolean[][] visited = new boolean[n][m];
        LinkedList<Node> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Node(x, y));
        int count = 1;
        while (!q.isEmpty()) {
            Node node = q.removeFirst();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i], ny = node.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (graph[nx][ny] == graph[x][y] && !visited[nx][ny]) {
                    count++;
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }
        return count * graph[x][y];
    }

    static int n, m, k;
    static int[][] graph;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        Dice dice = new Dice(0, 0);
        int answer = 0;
        for (int i = 0; i < k; i++) {
            int nx = dice.x + dx[dice.dir], ny = dice.y + dy[dice.dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                dice.uTurn();
                nx = dice.x + dx[dice.dir];
                ny = dice.y + dy[dice.dir];
            }
            answer += bfs(nx, ny);
            dice.move();
            dice.x = nx;
            dice.y = ny;
            dice.setNextDir();
        }
        System.out.println(answer);
    }
}