class Solution {
    private static Map<Character, Character> map = new HashMap<>();
    static {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty() && (c == ')' || c == ']' || c == '}')) {
                return false;
            } else if (!stack.isEmpty() && stack.peek() == map.get(c)) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
