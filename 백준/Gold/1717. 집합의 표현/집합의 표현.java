import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int m, n;
    static Node[] nodes;
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
        private int depth = 1;
        private Node parent = null;

        public boolean isConnected(Node o) {
            return root() == o.root();
        }

        public void merge(Node o) {
            if (isConnected(o)) return;
            Node root1 = root();
            Node root2 = o.root();

            if (root1.depth > root2.depth) {
                root2.parent = root1;
            } else if (root1.depth < root2.depth) {
                root1.parent = root2;
            } else {
                root2.parent = root1;
                root1.depth += 1;
            }
        }

        private Node root() {
            if (parent == null) return this;
            return parent.root();
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        nodes = new Node[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new Node();
        }

        for (int i = 0; i < m; i++) {
            int oper = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
            Node node1 = nodes[a];
            Node node2 = nodes[b];
            if (oper == 0) {
                if (node1.isConnected(node2)) continue;
                node1.merge(node2);
            } else {
                if (node1.isConnected(node2)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}