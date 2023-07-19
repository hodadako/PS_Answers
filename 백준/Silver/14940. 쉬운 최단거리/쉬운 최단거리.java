import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[][] answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
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

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

        static class Node {
            int x, y, count;

            public Node(int x, int y, int count) {
                this.x = x;
                this.y = y;
                this.count = count;
            }
        }

        private static void bfs(int x, int y, int count) {
            int n = arr.length, m = arr[0].length;
            LinkedList<Node> q = new LinkedList<>();
            q.add(new Node(x, y, count));
            answer[x][y] = count;
            visited[x][y] = true;
            while (!q.isEmpty()) {
                Node node = q.removeFirst();
                int a = node.x, b = node.y, cur = node.count;
                for (int i = 0; i < 4; i++) {
                    int nx = a + dx[i], ny = b + dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (visited[nx][ny]) continue;
                    if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        answer[nx][ny] = cur + 1;
                        q.add(new Node(nx, ny, cur + 1));
                    }
                }
            }
        }

        public static void main(String[] args) {
            FastReader sc = new FastReader();
            int n = sc.nextInt(), m = sc.nextInt();
            Node start = null;
            arr = new int[n][m];
            answer = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                    if (arr[i][j] == 2) {
                        start = new Node(i, j, 0);
                    }
                }
            }

            bfs(start.x, start.y, start.count);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i == start.x && j == start.y) {
                        System.out.print(answer[i][j] + " ");
                    } else if (arr[i][j] == 1 && answer[i][j] > 0) {
                        System.out.print(answer[i][j] + " ");
                    } else if (arr[i][j] == 0) {
                        System.out.print(0 + " ");
                    } else {
                        System.out.print(-1 + " ");
                    }
                }
                System.out.println();
            }
        }
}