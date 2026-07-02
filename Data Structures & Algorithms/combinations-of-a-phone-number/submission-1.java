class Solution {
    String[] letters = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        backtrack(0, digits, new StringBuilder(), result);
        return result;
    }

    private void backtrack(
        int startDigit, String digits, StringBuilder current, List<String> result) {
        if (current.length() == digits.length()) {
            result.add(current.toString());
            return;
        }

        int curDigit = digits.charAt(startDigit) - '0';
        String curLetters = letters[curDigit - 2];
        for (int j = 0; j < curLetters.length(); j++) {
            current.append(curLetters.charAt(j));
            backtrack(startDigit + 1, digits, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
