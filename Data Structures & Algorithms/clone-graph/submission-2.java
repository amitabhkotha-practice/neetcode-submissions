/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node root) {
        if (root == null)
            return root;
        Map<Node, Node> oldToNew = new HashMap<>();
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (oldToNew.containsKey(node))
                continue;

            Node newNode = new Node(node.val);
            oldToNew.put(node, newNode);

            for (Node neighbour : node.neighbors) {
                stack.push(neighbour);
            }
        }

        for (Map.Entry<Node, Node> nodes : oldToNew.entrySet()) {
            Node node = nodes.getKey();
            Node newNode = nodes.getValue();
            if (newNode.neighbors == null) {
                newNode.neighbors = new ArrayList<Node>();
            }
            for (Node neighbour : node.neighbors) {
                newNode.neighbors.add(oldToNew.get(neighbour));
            }
        }
        return oldToNew.get(root);
    }
}