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

        Deque<Pair> queue = new ArrayDeque<>();
        int ans = 0;

        queue.offer(new Pair(root, 1));
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int depth = pair.depth;

            if(node != null) {
                ans = Math.max(ans, depth);
                queue.offer(new Pair(node.left, depth + 1));
                queue.offer(new Pair(node.right, depth + 1));
            }
        }

        return ans;
    }
}
