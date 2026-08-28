class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<Integer>();
        for (String s : tokens) {

            switch (s) {
                case "+": {
                    int op1 = numbers.pop();
                    int op2 = numbers.pop();
                    numbers.push(op1 + op2);
                } break;
                case "-": {
                    int op1 = numbers.pop();
                    int op2 = numbers.pop();
                    numbers.push(op2 - op1);
                } break;
                case "*": {
                    int op1 = numbers.pop();
                    int op2 = numbers.pop();
                    numbers.push(op1 * op2);
                } break;
                case "/": {
                    int op1 = numbers.pop();
                    int op2 = numbers.pop();
                    numbers.push(op2 / op1);
                } break;
                default:
                    numbers.push(Integer.valueOf(s));
                    break;
            }
        }

        return numbers.pop();
    }
}
