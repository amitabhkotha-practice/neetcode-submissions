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
    class Pair {
        boolean balanced;
        int height;

        Pair(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return balanced(root).balanced;
    }

    private Pair balanced(TreeNode root) {
        if (root == null)
            return new Pair(true, 0);

        Pair left = balanced(root.left);
        Pair right = balanced(root.right);

        boolean isBalanced =
            left.balanced && right.balanced && (Math.abs(left.height - right.height) <= 1);

        int height = Math.max(left.height, right.height) + 1;
        return new Pair(isBalanced, height);
    }
}
