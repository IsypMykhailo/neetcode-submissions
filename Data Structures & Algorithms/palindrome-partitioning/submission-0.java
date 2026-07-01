class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(0, 0, s, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int j, int i, String s, List<String> current, List<List<String>> result) {
        if (j == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (i == s.length()) return;
        if (isPalindrome(s.substring(j, i + 1))) {
            current.add(s.substring(j, i + 1));
            backtrack(i + 1, i + 1, s, current, result);
            current.remove(current.size() - 1);
        }
        backtrack(j, i + 1, s, current, result);
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
