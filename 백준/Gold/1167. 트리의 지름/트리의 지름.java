import java.util.*;
import java.io.*;

class Main {
    static int n, answer = 0, max = 0;
    static boolean[] dfsVisited;
    static boolean[] bfsVisited;
    static int[] indegree;
    static int[] distances;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
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

    private static void dfs(Node node) {
        if (indegree[node.num] == 1 && node.num != 1) {
            distances[node.num] = node.dist;
            max = Math.max(max, node.dist);
            return;
        }
        for (Node next : graph.get(node.num)) {
            if (!dfsVisited[next.num]) {
                dfsVisited[next.num] = true;
                dfs(new Node(next.num, node.dist + next.dist));
            }
        }
    }

    private static void bfs(int start) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        bfsVisited[start] = true;
        while (!q.isEmpty()) {
            Node node = q.removeFirst();
            answer = Math.max(answer, node.dist);
            for (Node next : graph.get(node.num)) {
                if (!bfsVisited[next.num]) {
                    bfsVisited[next.num] = true;
                    q.add(new Node(next.num, next.dist + node.dist));
                }
            }
        }
    }

    static class Node {
        int num, dist;

        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        dfsVisited = new boolean[n + 1];
        bfsVisited = new boolean[n + 1];
        indegree = new int[n + 1];
        distances = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int parent = sc.nextInt();
            ArrayList<Integer> inputs = new ArrayList<>();
            while (true) {
                int now = sc.nextInt();
                if (now != -1) {
                    inputs.add(now);
                } else {
                    break;
                }
            }
            for (int j = 0; j < inputs.size(); j+=2) {
                graph.get(parent).add(new Node(inputs.get(j), inputs.get(j + 1)));
                indegree[parent]++;
            }
        }
        dfsVisited[1] = true;
        dfs(new Node(1, 0));

        int index = 0;
        for (int i = 0; i < n + 1; i++) {
            if (distances[i] == max) {
                index = i;
                break;
            }
        }
        bfs(index);
        System.out.println(answer);
    }
}