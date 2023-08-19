import java.util.*;
import java.io.*;

class Main {
    private static final int INF = 80000000;
    static int n, m;
    static int start, end;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

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

    private static class Node {
        int now, dist;

        public Node(int now, int dist) {
            this.now = now;
            this.dist = dist;
        }
    }

    private static int dijkstra(int start, int end) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new Node(start, 0));
        distances[start] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (distances[node.now] < node.dist) continue;
            distances[node.now] = node.dist;
            for (Node next : graph.get(node.now)) {
                int cost = node.dist + next.dist;
                if (cost < distances[next.now]) {
                    distances[next.now] = cost;
                    pq.add(new Node(next.now, cost));
                }
            }
        }
        return distances[end];
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        start = sc.nextInt();
        end = sc.nextInt();

        int first = dijkstra(1, start) + dijkstra(start, end) + dijkstra(end, n);
        int second = dijkstra(1, end) + dijkstra(start, end) + dijkstra(start, n);
        System.out.println((first >= INF && second >= INF) ? -1 : Math.min(first, second));
    }
}