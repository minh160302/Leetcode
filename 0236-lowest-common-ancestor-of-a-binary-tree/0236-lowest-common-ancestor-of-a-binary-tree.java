/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val)
            return root;
        TreeNode lcaLeft = null;
        if (root.left != null)
            lcaLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode lcaRight = null;
        if (root.right != null)
            lcaRight = lowestCommonAncestor(root.right, p, q);
        if (lcaLeft != null && lcaRight != null)
            return root;
        return lcaLeft != null ? lcaLeft : lcaRight;
    }
}