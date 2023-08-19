import java.util.*;

class Solution {
    class Node {
        private int depth = 1;
        private Node parent = null;
        
        private long max;
        
        public Node (long max) {
            this.max = max;
        }
        
        public long max() {
            return root().max;
        }
        
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
                root1.depth++;
            }
            
            root1.max = root2.max = Math.max(root1.max, root2.max);
        }
        
        public Node root() {
            if (parent == null) return this;
            return parent.root();
        }
    }
    
    public long[] solution(long k, long[] room_number) {
        ArrayList<Long> answer = new ArrayList<>();
        HashMap<Long, Node> count = new HashMap<>();
        for (long number : room_number) {
            if (count.containsKey(number)) {
                number = count.get(number).max() + 1;
            }
            
            Node node = new Node(number);
            answer.add(number);
            count.put(number, node);
            if (count.containsKey(number - 1)) {
                node.merge(count.get(number - 1));
            }
            if (count.containsKey(number + 1)) {
                node.merge(count.get(number + 1));
            }
        }
        return answer.stream().mapToLong(Long::longValue).toArray();
    }
}