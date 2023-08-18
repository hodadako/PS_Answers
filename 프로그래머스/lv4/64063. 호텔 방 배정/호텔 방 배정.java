import java.util.*;

class Solution {
    private static class Node {
        private int depth = 1;
        private Node parent = null;

        private long max;

        public Node (long cur) {
            max = cur;
        }

        public boolean isConnected(Node o) {
            return root() == o.root();
        }

        public long max() {
            return root().max;
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

            root1.max = root2.max = Math.max(root1.max, root2.max);
        }

        private Node root() {
            if (parent == null) return this;
            return parent.root();
        }
    }

    public static long[] solution(long k, long[] room_number) {
        HashMap<Long, Node> key = new HashMap<>();
        ArrayList<Long> answer = new ArrayList<>();
        for (long now : room_number) {
            if (key.containsKey(now)) {
                now = key.get(now).max() + 1;
            }

            Node node = new Node(now);
            key.put(now, node);
            if (key.containsKey(now - 1)) {
                node.merge(key.get(now - 1));
            }
            if (key.containsKey(now + 1)) {
                node.merge(key.get(now + 1));
            }

            answer.add(now);
        }

        return answer.stream().mapToLong(Long::longValue).toArray();
    }

    public static void main(String[] args) {
        long k = 10L;
        long[] room_number = {1, 3, 4, 1, 3, 1};
    }
}