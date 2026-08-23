class Node {
    int key, value;
    Node prev, next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    int size = 0;
    int capacity;
    Node head, tail;

    Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
        head.prev = tail.next = null;

        cache = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            addNode(deleteNode(node));
            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            addNode(deleteNode(node));
            return;
        }

        Node node = new Node(key, value);
        if (cache.size() >= capacity) {
            Node delNode = tail.prev;
            cache.remove(delNode.key);
            deleteNode(delNode);
        }

        cache.put(key, node);
        addNode(node);
    }

    private void addNode(Node node) {
        Node next = head.next;

        head.next = node;
        node.prev = head;

        next.prev = node;
        node.next = next;
    }

    private Node deleteNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        node.next = null;
        node.prev = null;

        return node;
    }
}
