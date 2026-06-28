class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> tokensStack = new Stack();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int b = tokensStack.pop();
                int a = tokensStack.pop();
                tokensStack.push(a + b);
            } else if (tokens[i].equals("*")) {
                int b = tokensStack.pop();
                int a = tokensStack.pop();
                tokensStack.push(a * b);
            } else if (tokens[i].equals("-")) {
                int b = tokensStack.pop();
                int a = tokensStack.pop();
                tokensStack.push(a - b);
            } else if (tokens[i].equals("/")) {
                int b = tokensStack.pop();
                int a = tokensStack.pop();
                tokensStack.push(a / b);
            } else {
                tokensStack.push(Integer.parseInt(tokens[i]));
            }
        }

        return tokensStack.pop();
    }
}
