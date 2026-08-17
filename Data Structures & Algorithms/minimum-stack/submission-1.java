class MinStack {
    Stack<Integer> main, extra;
    public MinStack() {
        main = new Stack<Integer>();
        extra = new Stack<Integer>();
    }
    
    public void push(int val) {
        if(extra.isEmpty() || extra.peek() >= val)
            extra.push(val);
        main.push(val);
    }
    
    public void pop() {
        int val = main.pop();
        if(val == extra.peek())
            extra.pop();
    }
    
    public int top() {
        return main.peek();
    }
    
    public int getMin() {
        return extra.peek();
    }
}
