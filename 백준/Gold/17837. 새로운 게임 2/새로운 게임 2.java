import java.util.*;
import java.io.*;

class Main {
    static boolean con = true;
    static int n, k;
    static int[][] map;
    static Node[] nodes;
    static ArrayList<Integer>[][] count;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
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
        int x, y, dir, num;

        public Node(int x, int y, int dir, int num) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.num = num;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Node)) return false ;
            Node node = (Node) o;
            return num == node.num && dir == node.dir;
        }

        @Override
        public int hashCode() {
            return (num + "," + dir).hashCode();
        }
    }

    private static int uTurn(int dir) {
        int result = 0;
        if (dir == 0) result = 1;
        else if (dir == 1) result = 0;
        else if (dir == 2) result = 3;
        else if (dir == 3) result = 2;
        return result;
    }

    private static int[] getNextMove(int num) {
        int[] nextMove = new int[2];
        boolean twice = false;
        Node node = nodes[num];
        int nx = node.x + dx[node.dir], ny = node.y + dy[node.dir];
        int nDir = uTurn(node.dir);
        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
            nx = node.x + dx[nDir];
            ny = node.y + dy[nDir];
            nodes[num].dir = nDir;
            twice = true;
        }

        if (map[nx][ny] == 0) {
            nextMove[0] = node.dir;
//            System.out.println("white");
        } else if (map[nx][ny] == 1) {
            nextMove[0] = node.dir;
            nextMove[1] = 1;
//            System.out.println("red");
        } else if (map[nx][ny] == 2) {
//            System.out.println("blue");
            if (twice) {
                return null;
            } else {
                nodes[num].dir = nDir;
                nx = node.x + dx[nDir];
                ny = node.y + dy[nDir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) return null;
                if (map[nx][ny] == 0) {
                    nextMove[0] = nodes[num].dir;
                } else if (map[nx][ny] == 1) {
                    nextMove[0] = nodes[num].dir;
                    nextMove[1] = 1;
                } else {
                    return null;
                }
            }
        }
        return nextMove;
    }

    private static void move(int num) {
//        System.out.println(num);
        int[] nextMove = getNextMove(num);
//        System.out.println(Arrays.toString(nextMove));
        if (nextMove == null) {
            return;
        }
        int x = nodes[num].x, y = nodes[num].y;
        int nx = nodes[num].x + dx[nextMove[0]], ny = nodes[num].y + dy[nextMove[0]];
        int index = count[x][y].indexOf(num);
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = index; i < count[x][y].size(); i++) {
            int now = count[x][y].get(i);
            temp.add(now);
        }

        if (nextMove[1] == 1) {
            Collections.reverse(temp);
        }

        ArrayList<Integer> original = new ArrayList<>();
        for (int i : count[x][y]) {
            if (!temp.contains(i)) {
                original.add(i);
            }
        }
        count[x][y] = original;
        count[nx][ny].addAll(temp);
        for (int i : temp) {
            nodes[i].x = nx;
            nodes[i].y = ny;
        }

        if (count[nx][ny].size() >= 4) {
            con = false;
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(count[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("____________________");
    }

    private static void cycle() {
        for (int i = 0; i < k; i++) {
            move(i);
            if (!con) break;
        }
    }

    private static boolean check() {
        boolean result = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j].size() >= 4) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        k = sc.nextInt();
        map = new int[n][n];
        count = new ArrayList[n][n];
        nodes = new Node[k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                count[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < k; i++) {
            int x = sc.nextInt(), y = sc.nextInt(), dir = sc.nextInt();
            Node node = new Node(x - 1, y - 1, dir - 1, i);
            nodes[i] = node;
            count[x - 1][y - 1].add(i);
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(count[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("____________________");

        int count = 0;
        for (int i = 0; i < 1001; i++) {
            count++;
            cycle();
            if (!con) break;
        }

        System.out.println(count > 1000 ? -1 : count);
    }
}