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

    static class Fireball {
        int mass, speed, direction;

        public Fireball(int mass, int speed, int direction) {
            this.mass = mass;
            this.speed = speed;
            this.direction = direction;
        }
    }

    static int n, m, k;
    static ArrayList<Fireball>[][] balls;

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    private static void move(int x, int y, Fireball fireball, ArrayList<Fireball>[][] ballsCopy) {
        for (int i = 0; i < fireball.speed; i++) {
            x += dx[fireball.direction];
            y += dy[fireball.direction];
            if (x < 0) {
                x = n - 1;
            }
            if (x >= n) {
                x = 0;
            }
            if (y < 0) {
                y = n - 1;
            }
            if (y >= n) {
                y = 0;
            }
        }
        ballsCopy[x][y].add(fireball);
    }

    private static void next() {
        ArrayList<Fireball>[][] ballsCopy = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ballsCopy[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!balls[i][j].isEmpty()) {
                    for (Fireball f : balls[i][j]) {
                        move(i, j, f, ballsCopy);
                    }
                }
            }
        }
        balls = ballsCopy;
    }

    private static void sumF() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cur = balls[i][j].size();
                if (cur >= 2) {
                    ArrayList<Fireball> temp = new ArrayList<>();
                    int totalMass = 0, totalSpeed = 0, dir = -1;
                    boolean even = true;
                    for (Fireball f : balls[i][j]) {
                        totalMass += f.mass;
                        totalSpeed += f.speed;
                        if (dir == -1) {
                            dir = f.direction % 2;
                        } else if (dir != -1 && dir != f.direction % 2) {
                            even = false;
                        }
                    }
                    if (totalMass / 5 > 0) {
                        if (even) {
                            temp.add(new Fireball(totalMass / 5, totalSpeed / cur, 0));
                            temp.add(new Fireball(totalMass / 5, totalSpeed / cur, 2));
                            temp.add(new Fireball(totalMass / 5, totalSpeed / cur, 4));
                            temp.add(new Fireball(totalMass / 5, totalSpeed / cur, 6));
                        } else {
                            temp.add(new Fireball(totalMass / 5, totalSpeed / cur, 1));
                            temp.add(new Fireball(totalMass / 5, totalSpeed / cur, 3));
                            temp.add(new Fireball(totalMass / 5, totalSpeed / cur, 5));
                            temp.add(new Fireball(totalMass / 5, totalSpeed / cur, 7));
                        }
                    }

                    balls[i][j] = new ArrayList<>(temp);
                }
            }
        }
    }

    private static int solve() {
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!balls[i][j].isEmpty()) {
                    for (Fireball f : balls[i][j]) {
                        total += f.mass;
                    }
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        balls = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                balls[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            int r = sc.nextInt() - 1, c = sc.nextInt() - 1, m = sc.nextInt(), s = sc.nextInt(), d = sc.nextInt();
            balls[r][c].add(new Fireball(m, s, d));
        }

        for (int i = 0; i < k; i++) {
            next();
            sumF();
        }

        System.out.println(solve());
    }
}