class Node {
    boolean end;
    Node[] children = new Node[26];
}
class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null)
                curr.children[idx] = new Node();
            curr = curr.children[idx];
        }
        curr.end = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int idx, Node node) {
        Node curr = node;

        for(int i = idx; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == '.') {
                for(Node child: curr.children) {
                    if(child != null && dfs(word, i + 1, child)) 
                    return true;
                }

                return false;
            } else {
                if(curr.children[c - 'a'] == null)
                    return false;
                
                curr = curr.children[c - 'a'];
            }
        }

        return curr.end;
    }
}
