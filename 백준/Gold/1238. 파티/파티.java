import java.sql.Array;
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
        int now, time;

        public Node(int now, int time) {
            this.now = now;
            this.time = time;
        }
    }

    static final int INF = (int) 1e9;
    static int n, m, start;
    static ArrayList<ArrayList<Node>> forward = new ArrayList<>();
    static ArrayList<ArrayList<Node>> backward = new ArrayList<>();
    static int[] timesStart;
    static int[] timesBack;

    private static void dijkstra(int start, ArrayList<ArrayList<Node>> graph, int[] times) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        times[start] = 0;
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (times[node.now] < node.time) {
                continue;
            }
            for (Node next : graph.get(node.now)) {
                int cost = next.time + node.time;
                if (cost < times[next.now]) {
                    times[next.now] = cost;
                    pq.add(new Node(next.now, cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();
        timesStart = new int[n + 1];
        timesBack = new int[n + 1];

        Arrays.fill(timesStart, INF);
        Arrays.fill(timesBack, INF);

        for (int i = 0; i <= n; i++) {
            forward.add(new ArrayList<>());
            backward.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), time = sc.nextInt();
            forward.get(a).add(new Node(b, time));
            backward.get(b).add(new Node(a, time));
        }

        dijkstra(start, forward, timesStart);
        dijkstra(start, backward, timesBack);

        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            answer = Math.max(answer, timesStart[i] + timesBack[i]);
        }
        
        System.out.println(answer);
    }


}