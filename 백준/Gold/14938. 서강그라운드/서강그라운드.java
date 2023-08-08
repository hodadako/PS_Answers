import java.util.*;
import java.io.*;


class Main {
    static int answer = 0;
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
        int length, cur;

        public Node(int length, int cur) {
            this.length = length;
            this.cur = cur;
        }
    }

    private static void dijkstra(ArrayList<ArrayList<Integer>> graph, int[] items, int[][] length, int start, int m, int[] dist, boolean[] visited) {
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.length - o2.length));
        pq.add(new Node(0, start));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (dist[node.cur] < node.length) continue;
            for (int i : graph.get(node.cur)) {
                int cost = node.length + length[node.cur][i];
                if (cost < dist[i]) {
                    dist[i] = cost;
                    pq.add(new Node(cost, i));
                }
            }
        }
        int total = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] <= m) {
                total += items[i];
            }
        }
//        System.out.println(Arrays.toString(dist));

        answer = Math.max(answer, total);
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt(), m = sc.nextInt(), r = sc.nextInt();
        int[] items = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            items[i] = sc.nextInt();
        }
        int[][] length = new int[n + 1][n + 1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < r; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), l = sc.nextInt();
            length[a][b] = l;
            length[b][a] = l;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

//        System.out.println(Arrays.toString(items));
//        System.out.println(graph);
        int[] dist = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
//            System.out.println(Arrays.toString(visited));
            Arrays.fill(dist, (int) 1e9);
            dijkstra(graph, items, length, i, m, dist, visited);
//            System.out.println("total = " + total);
            visited = new boolean[n + 1];
//            System.out.println(Arrays.toString(visited));
        }
        System.out.println(answer);
    }
}