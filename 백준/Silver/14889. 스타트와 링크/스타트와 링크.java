import org.w3c.dom.Node;

import java.util.*;
import java.io.*;


class Main {
    static ArrayList<ArrayList<Integer>> teams = new ArrayList<>();
    static int a, b;
    static int answer = Integer.MAX_VALUE;

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
    private static void getMin(ArrayList<Integer> h, ArrayList<Integer> t, ArrayList<Integer> head, ArrayList<Integer> tail, int index, int count, int[][] graph) {
        if (count == 0) {
            a += graph[h.get(0)][h.get(1)];
            b += graph[t.get(0)][t.get(1)];
            return;
        }

        for (int i = index; i < head.size(); i++) {
            h.add(head.get(i));
            t.add(tail.get(i));
            getMin(h, t, head, tail, i + 1, count - 1, graph);
            t.remove(t.size() - 1);
            h.remove(h.size() - 1);
        }
    }

    private static void combination(ArrayList<Integer> list, int[] nums, int index, int count) {
        if (count == 0) {
            teams.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            combination(list, nums, i + 1, count - 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
//                System.out.print(map[i][j] + " ");
            }
//            System.out.println();
        }

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }

//        System.out.println();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = map[i][j] + map[j][i];
//                System.out.print(graph[i][j] + " ");
            }
//            System.out.println();
        }

        combination(new ArrayList<>(), nums, 0, n / 2);
        for (int i = 0; i < teams.size(); i++) {
            a = 0;
            b = 0;
            getMin(new ArrayList<>(), new ArrayList<>(), teams.get(i), teams.get(teams.size() - i - 1), 0, 2, graph);
            answer = Math.min(answer, Math.abs(a - b));
        }
        System.out.println(answer);
    }
}