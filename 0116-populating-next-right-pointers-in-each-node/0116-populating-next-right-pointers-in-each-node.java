/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    Map<Integer, List<Node>> map = new HashMap<>();
    public Node connect(Node root) {
        int h = findHeight(root, 0);
        for (int i = 0; i < h; i++) {
            List<Node> nodes = map.get(i);
            for (int j = 0; j < nodes.size() - 1; j++) {
                nodes.get(j).next = nodes.get(j + 1);
            }
        }

        return root;
    }

    public int findHeight(Node node, int result) {
        if (node == null) {
            return result;
        }

        List<Node> temp = map.getOrDefault(result, new ArrayList<>());
        temp.add(node);
        map.put(result, temp);

        findHeight(node.left, result + 1);
        return findHeight(node.right, result + 1);
    }

    public void populate(Node node) {
        if (node == null) {
            return;
        }
    }
}