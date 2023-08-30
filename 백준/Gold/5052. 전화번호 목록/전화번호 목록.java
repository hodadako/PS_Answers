import java.io.*;
import java.util.*;

class Main {
    static int tc;
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
        HashMap<Character, Node> children = new HashMap<>();
        boolean end;
    }

    static class Trie {
        Node root = new Node();
        boolean integrity = true;

        void insert(String word) {
            Node node = this.root;

            for (int i = 0; i < word.length(); i++) {
                node.children.computeIfAbsent(word.charAt(i), key -> new Node());
                node = node.children.get(word.charAt(i));
                if (node.end) {
                    this.integrity = false;
                }
            }

            node.end = true;
        }
    }


    public static void main(String[] args) {
        FastReader sc = new FastReader();
        tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            int n = sc.nextInt();
            Trie trie = new Trie();
            String[] numbers = new String[n];
            for (int j = 0; j < n; j++) {
                numbers[j] = sc.next();
            }
            Arrays.sort(numbers);
            for (int j = 0; j < n; j++) {
                trie.insert(numbers[j]);
            }
            System.out.println(trie.integrity ? "YES" : "NO");
        }
    }
}