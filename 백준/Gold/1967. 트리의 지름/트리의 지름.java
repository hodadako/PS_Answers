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

    static int answer = 0;
    static int[] distances = new int[10001];
    static boolean[] visited1 = new boolean[10001];
    static int[] indegree = new int[10001];
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    static class Node {
        int num, distance;

        public Node(int num, int distance) {
            this.num = num;
            this.distance = distance;
        }
    }

    private static void dfs(Node node) {
        if (indegree[node.num] == 0) {
            distances[node.num] = node.distance;
            return;
        }

        for (Node next : graph.get(node.num)) {
            if (!visited1[next.num]) {
                visited1[next.num] = true;
                dfs(new Node(next.num, next.distance + node.distance));
            }
        }
    }

    private static void bfs(int start, boolean[] visited) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        while (!q.isEmpty()) {
            Node node = q.removeFirst();
            answer = Math.max(answer, node.distance);
            for (Node next : graph.get(node.num)) {
                if (!visited[next.num]) {
                    visited[next.num] = true;
                    q.add(new Node(next.num, next.distance + node.distance));
                }
            }
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();

        for (int i = 0; i < 10001; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
            indegree[a]++;
        }

        int index = 0;
        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0) {
                index = i;
            }
        }

        visited1[1] = true;
        dfs(new Node(1, 0));

        ArrayList<Integer> dist = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0) {
                dist.add(distances[i]);
            }
        }

        Collections.sort(dist, Collections.reverseOrder());
        int k = 0;
        for (int i = 0; i < n + 1; i++) {
            if (distances[i] == dist.get(0)) {
                k = i;
                break;
            }
        }

        boolean[] visited = new boolean[10001];
        visited[k] = true;
        bfs(k, visited);

        System.out.println(answer);
    }
}