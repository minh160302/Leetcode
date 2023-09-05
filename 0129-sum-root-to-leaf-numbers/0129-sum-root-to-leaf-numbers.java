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
    int res = 0;
    public int sumNumbers(TreeNode root) {
        traverse(root, 0);
        return res;
    }

    public void traverse(TreeNode root, int current) {
        if (root == null)
            return;
        current = current * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += current;
            return;
        }
        traverse(root.left, current);
        traverse(root.right, current);
    }
}