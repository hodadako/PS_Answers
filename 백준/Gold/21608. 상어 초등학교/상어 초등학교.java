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
    static int n;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static ArrayList<ArrayList<Integer>> prefer = new ArrayList<>();

    static class Node {
        int x, y, score;

        public Node(int x, int y, int score) {
            this.x = x;
            this.y = y;
            this.score = score;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getScore() {
            return score;
        }
    }

    private static int solve() {
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int score = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k], ny = j + dy[k];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (prefer.get(graph[i][j]).contains(graph[nx][ny])) {
                        score++;
                    }
                }

                if (score == 1) {
                    total++;
                } else if (score == 2) {
                    total += 10;
                } else if (score == 3) {
                    total += 100;
                } else if (score == 4){
                    total += 1000;
                }
            }
        }

        return total;
    }

    private static Node getScore(int now) {
        Node node = new Node(-1, -1, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int score = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k], ny = j + dy[k];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        if (graph[nx][ny] == 0) {
                            score++;
                        } else if (prefer.get(now).contains(graph[nx][ny])) {
                            score += 5;
                        }
                    }
                    if (score > node.score) {
                        node = new Node(i, j, score);
                    }
                }
            }
        }
        return node;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        graph = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i <= n * n; i++) {
            prefer.add(new ArrayList<>());
        }

        for (int i = 0; i < n * n; i++) {
            int now = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
            prefer.get(now).add(a);
            prefer.get(now).add(b);
            prefer.get(now).add(c);
            prefer.get(now).add(d);
            Node node = getScore(now);
            graph[node.x][node.y] = now;
            visited[node.x][node.y] = true;
        }

        System.out.println(solve());
    }
}