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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        process(root);
        return maxSum;
    }

    public int process(TreeNode root) {
        int sumLeft = 0;
        int sumRight = 0;
        int sum = root.val;        
        if (root.left != null)
            sumLeft = Math.max(0, process(root.left));
        if (root.right != null)
            sumRight = Math.max(0, process(root.right));

        sum += sumLeft + sumRight;
        maxSum = Math.max(maxSum, sum);
        return root.val + Math.max(sumLeft, sumRight);
    }
}