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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> result = new ArrayList<>();
        serialize(root, result);
        return String.join(",", result);
    }

    private void serialize(TreeNode node, List<String> result) {
        if(node == null) {
            result.add("N");
            return;
        }
        result.add(Integer.toString(node.val));
        serialize(node.left, result);
        serialize(node.right, result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        return deserialize(new int[]{0}, vals);
    }

    private TreeNode deserialize(int[] i, String[] vals) {
        if(vals[i[0]].equals("N")) {
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals[i[0]]));
        i[0]++;
        node.left = deserialize(i, vals);
        node.right = deserialize(i, vals);

        return node;
    }
}
