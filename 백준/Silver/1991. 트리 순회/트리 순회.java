import java.util.*;
import java.io.*;

class Main {
    static int n;
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
        Node left, right;
        char data;

        public Node(char data) {
            this.data = data;
        }
    }

    static class Tree {
        Node root;

        void insert(char rootData, char leftData, char rightData) {
            if (root == null) {
                root = new Node(rootData);
                root.left = leftData == '.' ? null : new Node(leftData);
                root.right = rightData == '.' ? null : new Node(rightData);
            } else {
                search(root.left, rootData, leftData, rightData);
                search(root.right, rootData, leftData,rightData);
            }
        }

        void search(Node node, char data, char leftData, char rightData) {
            if (node == null) {
                return;
            } else if (node.data == data) {
                node.left = leftData == '.' ? null : new Node(leftData);
                node.right = rightData == '.' ? null : new Node(rightData);
            } else if (node.data != data) {
                search(node.left, data, leftData, rightData);
                search(node.right, data, leftData, rightData);
            }
        }

        void preOrder(Node node) {
            if (node != null) {
                System.out.print(node.data);
                preOrder(node.left);
                preOrder(node.right);
            }
        }

        void inOrder(Node node) {
            if (node != null) {
                inOrder(node.left);
                System.out.print(node.data);
                inOrder(node.right);
            }
        }

        void postOrder(Node node) {
            if (node != null) {
                postOrder(node.left);
                postOrder(node.right);
                System.out.print(node.data);
            }
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        Tree tree = new Tree();
        for (int i = 0; i < n; i++) {
            String a = sc.next(), b = sc.next(), c = sc.next();
            tree.insert(a.charAt(0), b.charAt(0), c.charAt(0));
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
    }
}