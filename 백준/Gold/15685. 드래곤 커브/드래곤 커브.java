import java.util.*;
import java.io.*;

class Main {
    static int answer = 0;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static ArrayList<ArrayList<ArrayList<Integer>>> curves = new ArrayList<>();
    static int[][] graph = new int[101][101];
    static boolean[][] visited = new boolean[101][101];

    static class Node {
        int x, y;

        public Node(int x, int y) {
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

    private static void init() {
        for (int i = 0; i <= 10; i++) {
            curves.add(new ArrayList<>());
            for (int j = 0; j < 4; j++) {
                curves.get(i).add(new ArrayList<>());
            }
        }

        for (int i = 0; i < 4; i++) {
            curves.get(0).get(i).add(i);
        }
    }

    private static void add() {
        for (int i = 1; i <= 10; i++) {
            int size = curves.get(i - 1).get(0).size();
            for (int j = 0; j < 4; j++) {
                if (j == 3) {
                    curves.get(i).get(j).addAll(curves.get(i - 1).get(j));
                    for (int k = size - 1; k >= 0; k--) {
                        curves.get(i).get(j).add(curves.get(i - 1).get(0).get(k));
                    }
                } else {
                    curves.get(i).get(j).addAll(curves.get(i - 1).get(j));
                    for (int k = size - 1; k >= 0; k--) {
                        curves.get(i).get(j).add(curves.get(i - 1).get(j + 1).get(k));
                    }
                }
            }
        }
    }

    private static void move(int d, int g, int x, int y) {
        visited[x][y] = true;
        int nx = x, ny = y;
        for (int i : curves.get(g).get(d)) {
            nx += dx[i];
            ny += dy[i];
            visited[nx][ny] = true;
        }
    }

    private static void count() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (visited[i][j] && visited[i + 1][j] && visited[i][j + 1] && visited[i + 1][j + 1]) {
                    answer++;
                }
            }
        }
    }

    private static void print() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print((visited[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }

        System.out.println("_______________________________");
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        init();
        add();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt(), y = sc.nextInt(), d = sc.nextInt(), g = sc.nextInt();
            move(d, g, y, x);
        }
        count();
        System.out.println(answer);
    }
}