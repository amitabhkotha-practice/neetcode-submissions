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
        
        int ans = 0;
        Deque<Pair> stack = new ArrayDeque<>();
        stack.push(new Pair(root, 1));

        while(!stack.isEmpty())  {
            Pair pair = stack.pop();
            TreeNode node = pair.node;
            int depth = pair.depth;

            if(node != null) {
                ans = Math.max(ans, depth);
                stack.push(new Pair(node.left, depth + 1));
                stack.push(new Pair(node.right, depth + 1));
            } 
        }

        return ans;
    }
}
