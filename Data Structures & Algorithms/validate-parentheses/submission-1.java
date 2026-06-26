class Solution {
    public boolean isValid(String s) {
        Stack<Character> parenthesis = new Stack();
        for (int i = 0; i < s.length(); i++) {
            Character cur = s.charAt(i);
            if (cur == '(' || cur == '{' || cur == '[') {
                parenthesis.push(cur);
            } else {
                if (cur == ')') {
                    if (parenthesis.isEmpty() || parenthesis.peek() != '(') return false;
                    parenthesis.pop();
                } else if (cur == '}') {
                    if (parenthesis.isEmpty() || parenthesis.peek() != '{') return false;
                    parenthesis.pop();
                } else if (cur == ']') {
                    if (parenthesis.isEmpty() || parenthesis.peek() != '[') return false;
                    parenthesis.pop();
                }
            }
        }

        return parenthesis.isEmpty();
    }
}
