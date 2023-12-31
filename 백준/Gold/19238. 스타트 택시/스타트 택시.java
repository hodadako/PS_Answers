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

    // 1. 각 출발 점으로 부터의 택시 거리 미리 계산
    // 2. 현재 택시로 부터 최단 거리에 있는 손님 구하기
    // 3. 이동 시마다 남은 연료 량 체크
    static int N, M, F, SX, SY;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] graph;
    static boolean[][] visited;
    static boolean[][] pickUpVisited;
    static boolean[][] customerVisited;
    static HashMap<Node, Customer> customers = new HashMap<>();

    static class Customer {
        int cx, cy, tx, ty;
        int requiredFuel;

        public Customer(int cx, int cy, int tx, int ty) {
            this.cx = cx;
            this.cy = cy;
            this.tx = tx;
            this.ty = ty;
            this.requiredFuel = -1;
            bfs();
        }

        public void bfs() {
            visited = new boolean[N][N];
            LinkedList<Node> q = new LinkedList<>();

            visited[cx][cy] = true;
            q.add(new Node(cx, cy, 0));

            while (!q.isEmpty()) {
                Node node = q.poll();
                if (node.x == tx && node.y == ty) {
                    this.requiredFuel = node.count;
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (!visited[nx][ny] && graph[nx][ny] != 1) {
                            q.add(new Node(nx, ny, node.count + 1));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
    }

    static class Node {
        int x, y, count;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Node node = (Node)o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getCount() {
            return count;
        }
    }

    private static Node pickUp() {
        pickUpVisited = new boolean[N][N];
        ArrayList<Node> result = new ArrayList<>();
        LinkedList<Node> q = new LinkedList<>();
        visited[SX][SY] = true;
        q.add(new Node(SX, SY, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (graph[node.x][node.y] == 2 && customers.containsKey(node)) {
                if (F - node.count >= 0 && !result.contains(node)) {
                    result.add(node);
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    Node now = new Node(nx, ny, node.count + 1);
                    if (graph[nx][ny] != 1 && !pickUpVisited[nx][ny]) {
                        q.add(now);
                        pickUpVisited[nx][ny] = true;
                    }
                }
            }
        }

        Collections.sort(result, Comparator.comparing(Node::getCount).thenComparing(Node::getX).thenComparing(Node::getY));
        // for (Node node : result) {
        //     System.out.println("node.x = " + node.x);
        //     System.out.println("node.y = " + node.y);
        //     System.out.println("node.count = " + node.count);
        // }
        // System.out.println("_____________________________________");
        Node node = null;
        if (!result.isEmpty()) {
            node = result.get(0);
            customerVisited[node.x][node.y] = true;
        }
        return node;
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();

        N = fr.nextInt();
        M = fr.nextInt();
        F = fr.nextInt();

        graph = new int[N][N];
        customerVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = fr.nextInt();
            }
        }

        SX = fr.nextInt() - 1;
        SY = fr.nextInt() - 1;

        for (int i = 0; i < M; i++) {
            int cx = fr.nextInt() - 1, cy = fr.nextInt() - 1;
            int tx = fr.nextInt() - 1, ty = fr.nextInt() - 1;
            graph[cx][cy] = 2;
            customers.put(new Node(cx, cy), new Customer(cx, cy, tx, ty));
        }

        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j < N; j++) {
        //         System.out.print(graph[i][j] + " ");
        //     }
        //     System.out.println();
        // }


        while (M != 0) {
            Node next = pickUp();
            if (next != null) {
                // System.out.println("next.count = " + next.count);
                // System.out.println("F = " + F);
                F -= next.count;
                Customer now = customers.get(next);
                // System.out.println("now.requiredFuel = " + now.requiredFuel);
                // System.out.println("now.tx = " + now.tx);
                // System.out.println("now.ty = " + now.ty);
                if (F - now.requiredFuel < 0 || now.requiredFuel == -1) {
                    break;
                } else {
                    M--;
                    F += now.requiredFuel;
                    SX = now.tx;
                    SY = now.ty;
                    customers.remove(next);
                }
            } else {
                break;
            }
        }

        System.out.println(M == 0 ? F : -1);
    }
}