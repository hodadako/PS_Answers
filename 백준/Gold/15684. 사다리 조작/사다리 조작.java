import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {0, 0};
    static int[] dy = {-1, 1};
    static int[] mx = {0, 0};
    static int[] my = {-1, 0};
    static int n, m, h, answer = Integer.MAX_VALUE;
    static int[][] graph;
    static boolean[][] bridges, control;
    static ArrayList<Node> nodes = new ArrayList<>();

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
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void move(int size) {
        boolean change = true;
        for (int i = 0; i < n; i++) {
            int start = i;
            for (int j = 0; j < h; j++) {
                for (int k = 0; k < 2; k++) {
                    int nx = j + mx[k], ny = start + my[k];
                    if (nx < 0 || nx >= h || ny < 0 || ny >= n - 1) continue;
                    if (bridges[nx][ny]) {
                        if (start == ny) {
                            start++;
                            break;
                        } else if (start > ny) {
                            start--;
                            break;
                        }
                    }
                }
            }
            if (start != i) {
                change = false;
                break;
            }
        }

        if (change) answer = Math.min(answer, size);
    }

    private static void combination(ArrayList<Node> list, int index, int count) {
        if (count == 0) {
            for (Node node : list) {
                bridges[node.x][node.y] = true;
            };
            move(list.size());
            for (int i = 0; i < h; i++) {
                bridges[i] = Arrays.copyOf(control[i], control[i].length);
            }
            return;
        }

        for (int i = index; i < nodes.size(); i++) {
            list.add(nodes.get(i));
            combination(list, i + 1, count - 1);
            list.remove(list.size() - 1);
        }
    }

    private static void init() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n - 1; j++) {
                boolean add = true;
                if (bridges[i][j]) continue;
                for (int k = 0; k < 2; k++) {
                    int nx = i + dx[k], ny = j + dy[k];
                    if (nx < 0 || nx >= h || ny < 0 || ny >= n - 1) continue;
                    if (bridges[nx][ny]) add = false;
                }

                if (add) {
                    nodes.add(new Node(i, j));
                }
            }
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();
        graph = new int[h][n];
        bridges = new boolean[h][n - 1];
        control = new boolean[h][n - 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            bridges[a - 1][b - 1] = true;
            control[a - 1][b - 1] = true;
        }

        if (m == 0) {
            System.out.println(0);
        } else {
            move(0);
            init();

            for (int i = 1; i < 4; i++) {
                combination(new ArrayList<>(), 0, i);
            }

            System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        }
    }
}