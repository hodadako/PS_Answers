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

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static int n, answer = (int) 1e9;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = 1; j < n - 1; j++) {
                gerrymander(i, j);
            }
        }

        System.out.println(answer);
    }

    private static void gerrymander(int x, int y) {
        for (int i = 1; i < n - y; i++) {
            for (int j = 1; j <= y; j++) {
                draw(x, y, j, i);
            }
        }
    }

    private static void draw(int x, int y, int d1, int d2) {
        if (x + d1 + d2 >= n) {
            return;
        }
        int[][] graph = new int[n][n];
        graph[x][y] = 5;
        boolean[][] visited = new boolean[n][n];
        ArrayList<Integer> populations = new ArrayList<>();
        int total = 0, sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0;
        int nx = x + d1, ny = y - d1;
        visited[x][y] = true;
        total += map[x][y];
        while (nx != x && ny != y) {
            if (!visited[nx][ny]) {
                total += map[nx][ny];
                graph[nx][ny] = 5;
                visited[nx][ny] = true;
            }
            nx--;
            ny++; 
        }
        nx = x + d2;
        ny = y + d2;
        while (nx != x && ny != y) {
            if (!visited[nx][ny]) {
                total += map[nx][ny];
                graph[nx][ny] = 5;

                visited[nx][ny] = true;
            }
            nx--;
            ny--;
        }
        nx = x + d1 + d2;
        ny = y - d1 + d2;
        while (nx != x + d1 && ny != y - d1) {
            if (!visited[nx][ny]) {
                total += map[nx][ny];
                graph[nx][ny] = 5;

                visited[nx][ny] = true;
            }
            nx--;
            ny--;
        }
        nx = x + d1 + d2;
        ny = y - d1 + d2;
        while (nx != x + d2 && ny != y + d2) {
            if (!visited[nx][ny]) {
                total += map[nx][ny];
                graph[nx][ny] = 5;

                visited[nx][ny] = true;
            }
            nx--;
            ny++;
        }
        if (graph[x + 2][y] == 0 && graph[x + 1][y] == 0) {
            total += bfs(x + 1, y, visited);
        } else if (graph[x + 1][y] == 0) {
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int px = i + dx[k], py = j + dy[k];
                        if (visited[px][py]) {
                            count++;
                        }
                    }

                    if (count == 4) {
                        graph[i][j] = 5;
                        visited[i][j] = true;
                        total += map[i][j];
                    }
                }
            }
        }
        populations.add(total);

        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (!visited[i][j]) {
                    sum1 += map[i][j];
                    graph[i][j] = 1;
                }
            }
        }
        populations.add(sum1);

        for (int i = 0; i <= x + d2; i++) {
            for (int j = y + 1; j < n; j++) {
                if (!visited[i][j]) {
                    sum2 += map[i][j];
                    graph[i][j] = 2;
                }
            }
        }
        populations.add(sum2);

        for (int i = x + d1; i < n; i++) {
            for (int j = 0; j < y -d1 + d2; j++) {
                if (!visited[i][j]) {
                    sum3 += map[i][j];
                    graph[i][j] = 3;
                }
            }
        }
        populations.add(sum3);

        for (int i = x + d2 + 1; i < n; i++) {
            for (int j = y - d1 + d2; j < n; j++) {
                if (!visited[i][j]) {
                    sum4 += map[i][j];
                    graph[i][j] = 4;
                }
            }
        }
        populations.add(sum4);

        Collections.sort(populations);

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("____________________________");
        answer = Math.min(answer, populations.get(4) - populations.get(0));
    }

    private static int bfs(int x, int y, boolean[][] visited) {
        int result = 0;
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        result += map[x][y];
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Node node = q.removeFirst();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i], ny = node.y + dy[i];
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    result += map[nx][ny];
                    q.add(new Node(nx, ny));
                }
            }
        }
        return result;
    }
}