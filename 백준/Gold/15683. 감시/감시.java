import java.io.*;
import java.util.*;

class Main {
    static int answer = Integer.MAX_VALUE;
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] graph;
    static boolean[][] visited;
    static int[][][] types = {{}, {{0}, {1}, {2}, {3}}, {{0, 2}, {1, 3}}, {{0, 1}, {1, 2}, {2, 3}, {3, 0}},{{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, {{0, 1, 2, 3}}};
    static ArrayList<Node> nodes = new ArrayList<>();
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
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
        int x, y, type;

        public Node(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    static void dfs(int depth, int[][] arr) {
        if (depth == nodes.size()) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 0) {
                        count++;
                    }
                }
            }
            answer = Math.min(count, answer);
            return;
        }

        int[][] temp = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
        Node node = nodes.get(depth);
        for (int[] key : types[node.type]) {
            fill(temp, key, node.x, node.y);
            dfs(depth + 1, temp);
            temp = new int[n][m];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = Arrays.copyOf(arr[i], arr[i].length);
            }
        }
    }

    static void fill(int[][] arr, int[] key, int x, int y) {
        for (int i : key) {
            int nx = x, ny = y;
            while (true) {
                nx += dx[i];
                ny += dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    break;
                }
                if (arr[nx][ny] == 6) {
                    break;
                } else if (arr[nx][ny] == 0) {
                    arr[nx][ny] = 7;
                }
            }
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] > 0 && graph[i][j] < 6) {
                    nodes.add(new Node(i, j, graph[i][j]));
                }
            }
        }

        dfs(0, graph);
        
        System.out.println(answer);
    }
}