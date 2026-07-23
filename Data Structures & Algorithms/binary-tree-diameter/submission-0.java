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
    public int diameterOfBinaryTree(TreeNode root) {
        int result[] = new int[1];
        result[0] = -1;
        height(root, result);
        return result[0];
    }

    private int height(TreeNode root, int[] result) {
        if(root == null)
            return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftHeight = height(left, result);
        int rightHeight = height(right, result);
        int height = 1 + Math.max(leftHeight, rightHeight);
        result[0] = Math.max(result[0], leftHeight + rightHeight);
        return height;
    }
}
