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

    private static void fireStorm(int level, int total) {
        int len = 1;
        for (int i = 0; i < level; i++) {
            len *= 2;
        }
        int[][] temp = new int[len][len];
        for (int i = 0; i < total; i += len) {
            for (int j = 0; j < total; j += len) {
                for (int k = 0; k < len; k++) {
                    for (int l = 0; l < len; l++) {
                        temp[k][l] = ice[i + k][j + l];
                    }
                }

                temp = clockwise(temp);
                for (int k = 0; k < len; k++) {
                    for (int l = 0; l < len; l++) {
                        ice[i + k][j + l] = temp[k][l];
                    }
                }
                temp = new int[len][len];
            }
        }
    }

    private static int[][] clockwise(int[][] arr) {
        int cur = arr.length;
        int[][] temp = new int[cur][cur];
        for (int i = 0; i < cur; i++) {
            for (int j = 0; j < cur; j++) {
                temp[j][cur - 1 - i] = arr[i][j];
            }
        }
        return temp;
    }

    private static void melt(int total) {
        int[][] temp = new int[total][total];
        for (int i = 0; i < total; i++) {
            for (int j = 0; j < total; j++) {
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k], ny = j + dy[k];
                    if (nx < 0 || nx >= total || ny < 0 || ny >= total) continue;
                    if (ice[nx][ny] > 0) {
                        count++;
                    }
                }

                if (count < 3 && ice[i][j] > 0) {
                    temp[i][j] = ice[i][j] - 1;
                } else {
                    temp[i][j] = ice[i][j];
                }
            }
        }
        ice = temp;
    }

    private static void count(int total) {
        for (int i = 0; i < total; i++) {
            for (int j = 0; j < total; j++) {
                answer += ice[i][j];
            }
        }
    }

    private static void print(int total, int level) {
        System.out.println("level = " + level);
        for (int i = 0; i < total; i++) {
            for (int j = 0; j < total; j++) {
                System.out.print(ice[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("_________________________________");
    }

    private static void bfs(int x, int y, int total) {
        LinkedList<Node> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Node(x, y));
        int count = 1;
        while (!q.isEmpty()) {
            Node node = q.removeFirst();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i], ny = node.y + dy[i];
                if (nx < 0 || nx >= total || ny < 0 || ny >= total) continue;
                if (ice[nx][ny] > 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                    count++;
                }
            }
        }
        size = Math.max(size, count);
    }

    static int n, q, answer = 0, size = 0;
    static int[][] ice;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};


    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        q = sc.nextInt();
        int len = 1;
        for (int i = 0; i < n; i++) {
            len *= 2;
        }
        ice = new int[len][len];
        visited = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                ice[i][j] = sc.nextInt();
            }
        }


        for (int i = 0; i < q; i++) {
            int level = sc.nextInt();
            fireStorm(level, len);
            melt(len);
        }

        count(len);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (!visited[i][j] && ice[i][j] > 0) {
                    bfs(i, j, len);
                }
            }
        }

        System.out.println(answer);
        System.out.println(size);
    }
}