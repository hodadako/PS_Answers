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
        long now, count;

        public Node(long now, long count) {
            this.now = now;
            this.count = count;
        }
    }
    static long a, b;
    static long answer = Long.MAX_VALUE;

    private static void bfs(long now) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(now, 0));
        while (!q.isEmpty()) {
            Node node = q.removeFirst();
            if (node.now == b) {
                answer = Math.min(answer, node.count);
            }
            if (node.now * 2 <= b) {
                q.add(new Node(node.now * 2, node.count + 1));
            }
            if (node.now * 10 + 1 <= b) {
                q.add(new Node(node.now * 10 + 1, node.count + 1));
            }
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        a = sc.nextLong();
        b = sc.nextLong();
        bfs(a);
        System.out.println(answer == Long.MAX_VALUE ? -1 : answer + 1);
    }
}