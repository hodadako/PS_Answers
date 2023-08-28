import java.util.*;
import java.io.*;

class Main {
    static int[][] map;
    static boolean[][] height;
    static boolean[][] width;
    static boolean[] h1;
    static boolean[] h2;
    static boolean[] w1;
    static boolean[] w2;

    static int n, l;

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

        public static void main(String[] args) {
            FastReader sc = new FastReader();
            n = sc.nextInt();
            l = sc.nextInt();
            map = new int[n][n];
            height = new boolean[n][n];
            width = new boolean[n][n];
            h1 = new boolean[n];
            h2 = new boolean[n];
            w1 = new boolean[n];
            w2 = new boolean[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            // 가로 정방향 비교
            for (int i = 0; i < n; i++) {
                boolean status = true;
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] - map[i][j + 1] == 1) {
                        ArrayList<Integer> next = new ArrayList<>();
                        for (int k = j + 1; k < j + 1 + l; k++) {
                            if (k >= n) {
                                status = false;
                                break;
                            } else if (map[i][k] == map[i][j] - 1){
                                next.add(k);
                            }
                        }
                        if (next.size() != l) {
                            status = false;
                        }
                        if (!status) {
                            break;
                        } else {
                            for (int k : next) {
                                width[i][k] = true;
                            }
                        }
                    } else if (map[i][j] - map[i][j + 1] >= 2) {
                        status = false;
                        break;
                    }

                    if (!status) break;
                }

                w1[i] = status;
            }


        //가로 역방향 비교
        for (int i = 0; i < n; i++) {
            boolean status = true;
            for (int j = n - 1; j > 0; j--) {
                if (map[i][j] - map[i][j - 1] == 1) {
                    ArrayList<Integer> next = new ArrayList<>();
                    for (int k = j - 1; k >= j - 1 - l + 1; k--) {
                        if (k < 0) {
                            status = false;
                            break;
                        } else if (map[i][k] == map[i][j] - 1){
                            next.add(k);
                        }
                    }
                    if (next.size() != l) {
                        status = false;
                    }

                    if (!status) {
                        break;
                    } else {
                        for (int k : next) {
                            if (width[i][k]) {
                                status = false;
                                break;
                            } else {
                                width[i][k] = true;
                            }
                        }
                    }
                } else if (map[i][j] - map[i][j - 1] >= 2) {
                    status = false;
                    break;
                }

                if (!status) break;
            }

            w2[i] = status;
        }

        // 세로 정방향 비교
        for (int i = 0; i < n; i++) {
            boolean status = true;
            for (int j = 0; j < n - 1; j++) {
                if (map[j][i] - map[j + 1][i] == 1) {
                    ArrayList<Integer> next = new ArrayList<>();
                    for (int k = j + 1; k < j + 1 + l; k++) {
                        if (k >= n) {
                            status = false;
                            break;
                        } else if (map[k][i] == map[j][i] - 1){
                            next.add(k);
                        }
                    }
                    if (next.size() != l) {
                        status = false;
                    }

                    if (!status) {
                        break;
                    } else {
                        for (int k : next) {
                            height[k][i] = true;
                        }
                    }
                } else if (map[j][i] - map[j + 1][i] >= 2) {
                    status = false;
                    break;
                }
            }

            h1[i] = status;
        }


        //세로 역방향 비교
        for (int i = 0; i < n; i++) {
            boolean status = true;
            for (int j = n - 1; j > 0; j--) {
                if (map[j][i] - map[j - 1][i] == 1) {
                    ArrayList<Integer> next = new ArrayList<>();
                    for (int k = j - 1; k >= j - 1 - l + 1; k--) {
                        if (k < 0) {
                            status = false;
                            break;
                        } else if (map[k][i] == map[j][i] - 1){
                            next.add(k);
                        }
                    }
                    if (next.size() != l) {
                        status = false;
                    }

                    if (!status) {
                        break;
                    } else {
                        for (int k : next) {
                            if (height[k][i]) {
                                status = false;
                                break;
                            } else {
                                height[k][i] = true;
                            }
                        }
                    }
                } else if (map[j][i] - map[j - 1][i] >= 2) {
                    status = false;
                    break;
                }
            }

            h2[i] = status;
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (h1[i] && h2[i]) {
                answer++;
            }
            if (w1[i] && w2[i]) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}