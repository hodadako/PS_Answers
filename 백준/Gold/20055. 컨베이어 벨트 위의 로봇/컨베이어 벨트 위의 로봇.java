import java.util.*;
import java.io.*;

class Main {
    static int n, k;
    static int[] d, robot;

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

    private static void push() {
        if (robot[0] != 1 && d[0] != 0) {
            robot[0] = 1;
            d[0]--;
        }
    }

    private static void rotateBelt() {
        int[] belt = new int[2 * n];
        int[] p = new int[2 * n];
        belt[0] = d[2 * n - 1];
        for (int i = 0; i < 2 * n - 1; i++) {
            if (i == n - 2) {
                p[i + 1] = 0;
            } else {
                p[i + 1] = robot[i];
            }
            belt[i + 1] = d[i];
        }
        p[0] = 0;

        d = Arrays.copyOf(belt, belt.length);
        robot = Arrays.copyOf(p, p.length);
    }

    private static void move() {
        for (int i = n - 2; i >= 0; i--) {
            if (robot[i] == 1 && d[i + 1] != 0 && robot[i + 1] != 1) {
                robot[i + 1] = robot[i];
                robot[i] = 0;
                d[i + 1]--;
            }
        }

        if (robot[n - 1] == 1) {
            robot[n - 1] = 0;
        }
    }

    private static boolean check() {
        int total = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (d[i] == 0) {
                total++;
            }
        }
        return total >= k;
    }

    private static void print() {
        System.out.println("내구도");
        for (int i : d) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("현재 로봇의 위치");
        for (int i : robot) {
            System.out.print(i + " ");
        }
        System.out.println("____________________________");
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        k = sc.nextInt();
        d = new int[2 * n];
        robot = new int[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            d[i] = sc.nextInt();
        }

        int answer = 0;
        while (!check()) {
            rotateBelt();
            move();
            push();
            answer++;
        }

        System.out.println(answer);
    }
}