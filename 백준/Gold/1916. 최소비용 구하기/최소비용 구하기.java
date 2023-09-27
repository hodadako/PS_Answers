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

    static class Node {
        int next, dist;

        public Node(int next, int dist) {
            this.next = next;
            this.dist = dist;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return next == node.next;
        }

        @Override
        public int hashCode() {
            return Objects.hash(next);
        }
    }
    static final int INF = (int) 1e9;
    static int n, m;
    static int[] costs = new int[1001];
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (costs[node.next] < node.dist) {
                continue;
            }
            for (Node next : graph.get(node.next)) {
                if (node.dist + next.dist < costs[next.next]) {
                    costs[next.next] = node.dist + next.dist;
                    pq.add(new Node(next.next, next.dist + node.dist));
                }
            }
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), dist = sc.nextInt();
            graph.get(a).add(new Node(b, dist));
        }

        int start = sc.nextInt(), end = sc.nextInt();

        Arrays.fill(costs, INF);

        dijkstra(start);
        System.out.println(costs[end]);
    }
}