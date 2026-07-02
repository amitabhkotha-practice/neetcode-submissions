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

class Pair {
    TreeNode node;
    int depth;

    Pair(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        Deque<TreeNode> queue = new ArrayDeque<>();
        int ans = 0;

        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            ans++;
        }

        return ans;
    }
}
