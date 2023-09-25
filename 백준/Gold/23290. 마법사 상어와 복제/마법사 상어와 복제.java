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

    static class Fish {
        int x, y, dir;

        public Fish(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }


    static int m, s, fishNum = -1, sx, sy;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] mx = {-1, 0, 1, 0};
    static int[] my = {0, -1, 0, 1};

    static int[][] smell = new int[4][4];
    static ArrayList<Fish>[][] map = new ArrayList[4][4];
    static ArrayList<Fish> copy = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> sharkDirections = new ArrayList<>();
    static ArrayList<Integer> directions = new ArrayList<>();
    static ArrayList<Integer> curDir = new ArrayList<>();

    private static void copy() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                copy.addAll(map[i][j]);
            }
        }
    }

    private static void copyAdd() {
        for (Fish f : copy) {
            map[f.x][f.y].add(f);
        }
        copy.clear();
    }

    private static void permutation(ArrayList<Integer> list, int count) {
        if (count == 0) {
            sharkDirections.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < directions.size(); i++) {
            int now = directions.get(i);
            list.add(now);
            permutation(list, count - 1);
            list.remove(list.size() - 1);
        }
    }

    private static void getShortestPath() {
        for (ArrayList<Integer> steps : sharkDirections) {
            int nx = sx, ny = sy, total = 0;
            boolean add = true;
            boolean[][] check = new boolean[4][4];
            for (int i : steps) {
                nx += mx[i];
                ny += my[i];
                if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) {
                    add = false;
                    break;
                }
                check[nx][ny] = true;
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (check[i][j]) {
                        total += map[i][j].size();
                    }
                }
            }

            if (add) {
                if (fishNum < total) {
                    fishNum = total;
                    curDir = new ArrayList<>(steps);
                }
            }
        }
    }

    private static void moveShark() {
        int nx = sx, ny = sy;
        for (int i : curDir) {
            nx += mx[i];
            ny += my[i];
            if (map[nx][ny].size() > 0) {
                smell[nx][ny] = 2;
                map[nx][ny].clear();
            }
        }
        sx = nx;
        sy = ny;
        fishNum = -1;
        curDir = new ArrayList<>();
    }

    private static int anticlockwise(int dir) {
        dir--;
        if (dir < 0) {
            dir = 7;
        }
        return dir;
    }

    private static void moveFish() {
        ArrayList<Fish>[][] temp = new ArrayList[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                temp[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (Fish f : map[i][j]) {
                    int dir = f.dir;
                    int nextX = -1, nextY = -1;
                    for (int k = 0; k < 8; k++) {
                        int nx = f.x + dx[dir], ny = f.y + dy[dir];
                        if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) {
                            dir = anticlockwise(dir);
                            continue;
                        }

                        if (smell[nx][ny] == 0 && (nx != sx || ny != sy)) {
                            nextX = nx;
                            nextY = ny;
                            break;
                        } else if (smell[nx][ny] != 0) {
                            dir = anticlockwise(dir);
                        } else if (nx == sx && ny == sy) {
                            dir = anticlockwise(dir);
                        }
                    }
                    if (nextX != -1 && nextY != -1) {
                        temp[nextX][nextY].add(new Fish(nextX, nextY, dir));
                    } else {
                        temp[f.x][f.y].add(f);
                    }
                }
            }
        }
        deleteSmell();
        map = temp;
    }

    private static void deleteSmell() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (smell[i][j] > 0) {
                    smell[i][j]--;
                }
            }
        }
    }

    private static int count() {
        int total = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                total += map[i][j].size();
            }
        }
        return total;
    }

    private static void print() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("________________________");
    }

    private static void printSmell() {
        System.out.println("SMELL+__________");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(smell[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("________________________");
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        m = sc.nextInt();
        s = sc.nextInt();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                map[i][j] = new ArrayList<>();
            }
            directions.add(i);
        }

        permutation(new ArrayList<>(), 3);

        for (int i = 0; i < m; i++) {
            int fx = sc.nextInt() - 1, fy = sc.nextInt() - 1, d = sc.nextInt() - 1;
            map[fx][fy].add(new Fish(fx, fy, d));
        }

        sx = sc.nextInt() - 1;
        sy = sc.nextInt() - 1;

        for (int i = 0; i < s; i++) {
            copy();
            moveFish();
            getShortestPath();
            moveShark();
            copyAdd();
        }

        System.out.println(count());
    }
}