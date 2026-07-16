class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> leftParenthesis = new Stack<>();
        Stack<Integer> star = new Stack<>();

        char[] sChars = s.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] == '(') leftParenthesis.push(i);
            else if (sChars[i] == '*') star.push(i);
            else {
                if (!leftParenthesis.isEmpty()) leftParenthesis.pop();
                else if (!star.isEmpty()) star.pop();
                else return false;
            }
        }

        while(!leftParenthesis.isEmpty() && !star.isEmpty()) {
            if (leftParenthesis.pop() > star.pop()) return false;
        }

        return leftParenthesis.isEmpty();
    }
}
