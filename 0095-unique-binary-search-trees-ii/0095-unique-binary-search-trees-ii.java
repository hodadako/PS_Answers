/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<String, List<TreeNode>> memo = new HashMap<>();
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return build(1, n);
    }

    List<TreeNode> build(int start, int end) {
        String key = start + "," + end;
        if (memo.containsKey(key)) return memo.get(key);

        List<TreeNode> nodes = new ArrayList<>();
        if (start > end) {
            nodes.add(null);
            return nodes;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftT = build(start, i - 1);
            List<TreeNode> rightT = build(i + 1, end);

            for (TreeNode left : leftT) {
                for (TreeNode right : rightT) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    nodes.add(root);
                }
            }
        }
        memo.put(key, nodes);
        return nodes;
    }
}