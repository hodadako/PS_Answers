import java.util.*;
import java.io.*;

class Main {
    static int r, c, t;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static int[][] mapCopy;
    static ArrayList<Node> air = new ArrayList<>();
    static ArrayList<Node> top = new ArrayList<>();
    static ArrayList<Node> bottom = new ArrayList<>();

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return (this.x + "," + this.y).hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Node)) return false;
            Node other = (Node) obj;
            return this.x == other.x && this.y == other.y;
        }
    }
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

    private static void getTopCors(Node node) {
        top.add(node);
        LinkedList<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node now = q.removeFirst();
            int nx = now.x + dx[3], ny = now.y + dy[3];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) break;
            Node next = new Node(nx, ny);
            q.add(next);
            if (!top.contains(next)) {
                top.add(next);
            }
        }

        q.add(top.get(top.size() - 1));
        while (!q.isEmpty()) {
            Node now = q.removeFirst();
            int nx = now.x + dx[0], ny = now.y + dy[0];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) break;
            Node next = new Node(nx, ny);
            q.add(next);
            if (!top.contains(next)) {
                top.add(next);
            }
        }

        q.add(top.get(top.size() - 1));
        while (!q.isEmpty()) {
            Node now = q.removeFirst();
            int nx = now.x + dx[1], ny = now.y + dy[1];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) break;
            Node next = new Node(nx, ny);
            q.add(next);
            if (!top.contains(next)) {
                top.add(next);
            }
        }

        q.add(top.get(top.size() - 1));
        while (!q.isEmpty()) {
            Node now = q.removeFirst();
            int nx = now.x + dx[2], ny = now.y + dy[2];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) break;
            Node next = new Node(nx, ny);
            q.add(next);
            if (!top.contains(next)) {
                top.add(next);
            } else {
                break;
            }
        }
    }

    private static void getBottomCors(Node node) {
        bottom.add(node);
        LinkedList<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node now = q.removeFirst();
            int nx = now.x + dx[3], ny = now.y + dy[3];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) break;
            Node next = new Node(nx, ny);
            q.add(next);
            if (!bottom.contains(next)) {
                bottom.add(next);
            }
        }

        q.add(bottom.get(bottom.size() - 1));
        while (!q.isEmpty()) {
            Node now = q.removeFirst();
            int nx = now.x + dx[2], ny = now.y + dy[2];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) break;
            Node next = new Node(nx, ny);
            q.add(next);
            if (!bottom.contains(next)) {
                bottom.add(next);
            }
        }

        q.add(bottom.get(bottom.size() - 1));
        while (!q.isEmpty()) {
            Node now = q.removeFirst();
            int nx = now.x + dx[1], ny = now.y + dy[1];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) break;
            Node next = new Node(nx, ny);
            q.add(next);
            if (!bottom.contains(next)) {
                bottom.add(next);
            }
        }

        q.add(bottom.get(bottom.size() - 1));
        while (!q.isEmpty()) {
            Node now = q.removeFirst();
            int nx = now.x + dx[0], ny = now.y + dy[0];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) break;
            Node next = new Node(nx, ny);
            q.add(next);
            if (!bottom.contains(next)) {
                bottom.add(next);
            } else {
                break;
            }
        }
    }

    private static void circulation(ArrayList<Node> types, int[][] map) {
        LinkedList<Integer> q = new LinkedList<>();
        for (Node node : types) {
            q.add(map[node.x][node.y]);
        }

        q.addFirst(q.removeLast());
        for (int i = 0; i < types.size(); i++) {
            Node node = types.get(i);
            map[node.x][node.y] = q.get(i);
        }

        Node home = types.get(0);
        map[home.x][home.y] = -1;
    }

    private static void diffusion(int x, int y) {
        if (map[x][y] == 0 || map[x][y] == -1) {
            return;
        } else {
            int cur = map[x][y];
            int d = cur / 5;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (map[nx][ny] == -1) continue;
                if (map[nx][ny] >= 0) {
                    cur -= d;
                    mapCopy[nx][ny] += d;
                }
            }
            mapCopy[x][y] += cur;
        }
    }

    private static void print(int[][] arr) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("___________________________________________");
    }


    public static void main(String[] args) {
        FastReader sc = new FastReader();
        r = sc.nextInt();
        c = sc.nextInt();
        t = sc.nextInt();
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == -1) {
                    air.add(new Node(i, j));
                }
            }
        }
        getTopCors(air.get(0));
        getBottomCors(air.get(1));


        for (int i = 0; i < t; i++) {
            mapCopy = new int[r][c];
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    diffusion(j, k);
                }
            }
            circulation(top, mapCopy);
            circulation(bottom, mapCopy);
            for (Node node : air) {
                mapCopy[node.x][node.y] = -1;
            }

            map = Arrays.stream(mapCopy).map(int[]::clone).toArray(int[][]::new);
        }

        int total = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != -1) {
                    total += map[i][j];
                }
            }
        }

        System.out.println(total);
    }
}