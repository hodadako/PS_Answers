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
    boolean answer = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        compare(p, q);
        return answer;
    }
    
    void compare(TreeNode p, TreeNode q) {
        if (p != null && q == null) {
            answer = false;
            return;
        }
        if (p == null && q != null) {
            answer = false;
            return;
        }
        if (p == null && q == null) return;
        if (p.val != q.val) {
            answer = false;
            return;
        }

        compare(p.left, q.left);
        compare(p.right, q.right);
    }
}