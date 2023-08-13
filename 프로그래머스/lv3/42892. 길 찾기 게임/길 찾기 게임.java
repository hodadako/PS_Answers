import java.util.*;

class Solution {
    ArrayList<Integer> preOrderList = new ArrayList<>();
    ArrayList<Integer> postOrderList = new ArrayList<>();
    
    
    class Node {
        int data, x, y;
        Node left, right;
        
        public Node(int data, int x, int y) {
            this.data = data;
            this.x = x;
            this.y = y;
        }
    }
    
    class Tree {
        Node root;
        
        public Tree(Node node) {
            this.root = node;
        }
        
        public void createNode(Node root, Node node) {
            if (root == null) {
                this.root = root;
            } else {
                if (node.x < root.x) {
                    if (root.left == null) {
                        root.left = node;
                    } else {
                        createNode(root.left, node);
                    }
                } else {
                    if (root.right == null) {
                        root.right = node;
                    } else {
                        createNode(root.right, node);
                    }
                }
            }
        }
        
        public void preOrder(Node node) {
            if (node != null) {
                preOrderList.add(node.data);
                preOrder(node.left);
                preOrder(node.right);
            } 
        } 
        
        public void postOrder(Node node) {
            if (node != null) {
                postOrder(node.left);
                postOrder(node.right);
                postOrderList.add(node.data);
            }
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        Arrays.sort(nodes, (o1, o2) -> o2.y - o1.y);
        
        Tree binaryTree = new Tree(nodes[0]);
        for (int i = 1; i < n; i++) {
            binaryTree.createNode(binaryTree.root, nodes[i]);
        }
        
        binaryTree.preOrder(binaryTree.root);
        binaryTree.postOrder(binaryTree.root);
        
        int[][] answer = {preOrderList.stream().mapToInt(i -> i).toArray(), postOrderList.stream().mapToInt(i -> i).toArray()};
        return answer;
    }
}