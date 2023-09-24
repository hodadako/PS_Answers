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

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n, m, score = 0, sx = -1, sy = -1, rCount = 0;
    static ArrayList<Node> dots = new ArrayList<>();
    static ArrayList<Node> rainbows = new ArrayList<>();
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    private static void deleteBlocks() {
        score += dots.size() * dots.size();
        for (Node node : dots) {
            map[node.x][node.y] = -2;
        }
        dots.clear();
    }

    private static void findR() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    rainbows.add(new Node(i, j));
                }
            }
        }
    }

    private static void eraseVisits() {
        for (Node node : rainbows) {
            visited[node.x][node.y] = false;
        }
    }

    private static void bfs(int x, int y) {
        LinkedList<Node> q = new LinkedList<>();
        ArrayList<Node> cur = new ArrayList<>();
        q.add(new Node(x, y));
        cur.add(new Node(x, y));
        visited[x][y] = true;
        int count = 0;
        while (!q.isEmpty()) {
            Node node = q.removeFirst();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i], ny = node.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (!visited[nx][ny]) {
                    if (map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.add(new Node(nx, ny));
                        cur.add(new Node(nx, ny));
                        count++;
                    } else if (map[nx][ny] == map[x][y]) {
                        visited[nx][ny] = true;
                        q.add(new Node(nx, ny));
                        cur.add(new Node(nx, ny));
                    }
                }
            }
        }
        if (cur.size() > dots.size()) {
            sx = x;
            sy = y;
            rCount = count;
            dots = new ArrayList<>(cur);
        } else if (cur.size() == dots.size()) {
            if (rCount < count) {
                sx = x;
                sy = y;
                rCount = count;
                dots = new ArrayList<>(cur);
            } else if (rCount == count) {
                if (sx < x) {
                    sx = x;
                    sy = y;
                    rCount = count;
                    dots = new ArrayList<>(cur);
                } else if (sx == x) {
                    if (sy < y) {
                        sx = x;
                        sy = y;
                        rCount = count;
                        dots = new ArrayList<>(cur);
                    }
                }
            }
        }
    }

    private static void down() {
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == -1 || map[i][j] == -2) continue;
                if (map[i][j] >= 0) {
                    int nx = i, ny = j;
                    while (true) {
                        nx += dx[2];
                        ny += dy[2];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                            nx -= dx[2];
                            ny -= dy[2];
                            break;
                        }
                        if (map[nx][ny] >= -1) {
                            nx -= dx[2];
                            ny -= dy[2];
                            break;
                        }
                    }

                    int temp = map[i][j];
                    map[i][j] = -2;
                    map[nx][ny] = temp;
                }
            }
        }
    }

    private static void anticlockwise() {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = map[j][n - 1 - i];
            }
        }
        map = temp;
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] == -2 ? "M " : map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("_______________________________________");
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        while (true) {
            findR();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] != -2 && map[i][j] != -1 && map[i][j] != 0 && !visited[i][j]) {
                        bfs(i, j);
                        eraseVisits();
                    }
                }
            }
            if (dots.size() == 1 || dots.size() == 0) {
                break;
            } else {
                deleteBlocks();
                down();
                anticlockwise();
                down();
                visited = new boolean[n][n];
                sx = -1;
                sy = -1;
                rCount = 0;
                dots = new ArrayList<>();
                rainbows = new ArrayList<>();
            }
        }

        System.out.println(score);
    }
}