import java.io.*;
import java.util.*;

class Main {
    static int r, c, k;
    static int[][] arr = new int[3][3];
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
        int num, count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    private static void calcR() {
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            temp.add(new ArrayList<>());
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.count == b.count ? a.num - b.num : a.count - b.count);
            HashMap<Integer, Integer> dict = new HashMap<>();
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    dict.put(arr[i][j], dict.getOrDefault(arr[i][j],  0) + 1);
                }
            }

            for (int key : dict.keySet()) {
                pq.add(new Node(key, dict.get(key)));
            }

            while (!pq.isEmpty()) {
                Node node = pq.poll();
                temp.get(i).add(node.num);
                temp.get(i).add(node.count);
            }

            maxLen = Math.max(maxLen, temp.get(i).size());
        }

        for (int i = 0; i < arr.length; i++) {
            if (temp.get(i).size() < maxLen) {
                while (temp.get(i).size() != maxLen) {
                    temp.get(i).add(0);
                }
            }
        }

        arr = new int[arr.length][maxLen <= 100 ? maxLen : 100];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < (maxLen <= 100 ? maxLen : 100); j++) {
                arr[i][j] = temp.get(i).get(j);
            }
        }
    }

    private static void calcC() {
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        int maxLen = 0;
        for (int i = 0; i < arr[0].length; i++) {
            temp.add(new ArrayList<>());
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.count == b.count ? a.num - b.num : a.count - b.count);
            HashMap<Integer, Integer> dict = new HashMap<>();
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][i] != 0) {
                    dict.put(arr[j][i], dict.getOrDefault(arr[j][i],  0) + 1);
                }
            }

            for (int key : dict.keySet()) {
                pq.add(new Node(key, dict.get(key)));
            }

            while (!pq.isEmpty()) {
                Node node = pq.poll();
                temp.get(i).add(node.num);
                temp.get(i).add(node.count);
            }

            maxLen = Math.max(maxLen, temp.get(i).size());
        }

        for (int i = 0; i < arr[0].length; i++) {
            if (temp.get(i).size() < maxLen) {
                while (temp.get(i).size() != maxLen) {
                    temp.get(i).add(0);
                }
            }
        }

        arr = new int[maxLen <= 100 ? maxLen : 100][arr[0].length];
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < (maxLen <= 100 ? maxLen : 100); j++) {
                arr[j][i] = temp.get(i).get(j);
            }
        }
    }

    private static boolean check() {
        try {
            if (arr[r - 1][c - 1] != k) {
                return true;
            } else {
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
    }

    private static void print() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("____________________________");
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        r = sc.nextInt();
        c = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        while (check()) {
            if (arr.length >= arr[0].length) {
                calcR();
            } else {
                calcC();
            }
            answer++;
            if (answer == 101) {
                break;
            }
        }

        System.out.println(answer > 100 ? -1 : answer);
    }
}
