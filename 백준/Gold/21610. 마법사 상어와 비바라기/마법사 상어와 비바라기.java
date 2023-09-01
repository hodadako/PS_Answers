import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static ArrayList<Cloud> clouds = new ArrayList<>();

    static class Cloud {
        int x, y;

        public Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

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

    private static void cloudFirst() {
        clouds.add(new Cloud(n - 1, 0));
        clouds.add(new Cloud(n - 1, 1));
        clouds.add(new Cloud(n - 2, 0));
        clouds.add(new Cloud(n - 2, 1));
    }

    private static void move(int d, int s) {
        for (Cloud cloud : clouds) {
            cloud.x += dx[d - 1] * s;
            if (cloud.x < 0) {
                cloud.x = (n + cloud.x % n) % n;
            } else if (cloud.x >= n) {
                cloud.x %= n;
            }
            cloud.y += dy[d - 1] * s;
            if (cloud.y < 0) {
                cloud.y = (n + cloud.y % n) % n;
            } else if (cloud.y >= n) {
                cloud.y %= n;
            }
        }
    }

    private static void addRain() {
        int[] dx = {-1, -1, 1, 1};
        int[] dy = {-1, 1, -1, 1};
        for (Cloud cloud : clouds) {
            map[cloud.x][cloud.y]++;
            visited[cloud.x][cloud.y] = true;
        }

        for (Cloud cloud : clouds) {
            for (int i = 0; i < 4; i++) {
                int nx = cloud.x + dx[i], ny = cloud.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (map[nx][ny] > 0) {
                    map[cloud.x][cloud.y]++;
                }
            }
        }
    }

    private static void cloudSecond() {
        clouds.clear();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] >= 2) {
                    map[i][j] -= 2;
                    clouds.add(new Cloud(i, j));
                }
            }
        }
        visited = new boolean[n][n];
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] +  " ");
            }
            System.out.println();
        }
    }

    private static int sum() {
        return Arrays.stream(map).flatMapToInt(IntStream::of).sum();
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

        cloudFirst();
        for (int i = 0; i < m; i++) {
            int d = sc.nextInt(), s = sc.nextInt();
            move(d, s);
            addRain();
            cloudSecond();
        }
        System.out.println(sum());
    }
}