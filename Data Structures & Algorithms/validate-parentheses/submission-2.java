class Solution {
    public boolean isValid(String s) {
        Stack<Character> parenthesis = new Stack();
        for (int i = 0; i < s.length(); i++) {
            Character cur = s.charAt(i);
            switch (cur) {
                case '(':
                case '{':
                case '[':
                    parenthesis.push(cur);
                    break;
                case ')':
                    if (parenthesis.isEmpty() || parenthesis.pop() != '(') return false;
                    break;
                case '}':
                    if (parenthesis.isEmpty() || parenthesis.pop() != '{') return false;
                    break;
                case ']':
                    if (parenthesis.isEmpty() || parenthesis.pop() != '[') return false;
                    break;
                default:
                    break;
            }
        }

        return parenthesis.isEmpty();
    }
}
