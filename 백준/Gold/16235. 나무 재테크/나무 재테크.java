import java.util.*;
import java.io.*;

class Main {
    static int n, m, k;
    static int[][] winter;
    static int[][] nutrient;
    static ArrayList<Integer>[][] trees;
    static ArrayList<Integer>[][] deadTrees;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    static void grow(int x, int y) {
        ArrayList<Integer> treeList = new ArrayList<>();
        Collections.sort(trees[x][y]);
        boolean[] visited = new boolean[trees[x][y].size()];
        for (int i = 0; i < trees[x][y].size(); i++) {
            int age = trees[x][y].get(i);
            if (nutrient[x][y] >= age) {
                nutrient[x][y] = nutrient[x][y] - age;
                treeList.add(i, age + 1);
                visited[i] = true;
            } else {
                break;
            }
        }

        for (int i = 0; i < trees[x][y].size(); i++) {
            if (!visited[i]) {
                deadTrees[x][y].add(trees[x][y].get(i));
            }
        }
        trees[x][y] = new ArrayList<>(treeList);
    }

    static void addNutrient(int x, int y) {
        for (int i : deadTrees[x][y]) {
            nutrient[x][y] += i / 2;
        }
        deadTrees[x][y].clear();
    }

    static void child(int x, int y) {
        for (int i : trees[x][y]) {
            if (i % 5 == 0) {
                for (int j = 0; j < 8; j++) {
                    int nx = x + dx[j], ny = y + dy[j];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    trees[nx][ny].add(1);
                }
            }
        }
    }
    
    static void addWinterNutrient() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nutrient[i][j] += winter[i][j];
            }
        }
    }

    static void print() {
        System.out.println("____nutrient___________________________");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(nutrient[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("__________________________________");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(trees[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("__________________________________");
    }

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

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        winter = new int[n][n];
        nutrient = new int[n][n];
        trees = new ArrayList[n][n];
        deadTrees = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                winter[i][j] = sc.nextInt();
                trees[i][j] = new ArrayList<>();
                deadTrees[i][j] = new ArrayList<>();
            }
        }

        for (int[] now : nutrient) {
            Arrays.fill(now, 5);
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1, y = sc.nextInt() - 1 , z = sc.nextInt();
            trees[x][y].add(z);
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    grow(j, l);
                }
            }


            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    addNutrient(j, l);
                }
            }


            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    child(j, l);
                }
            }

            addWinterNutrient();
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer += trees[i][j].size();
            }
        }

        System.out.println(answer);
    }
}