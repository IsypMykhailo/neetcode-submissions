class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int j, String s, List<String> current, List<List<String>> result) {
        if (j == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = j; i < s.length(); i++) {
            String substr = s.substring(j, i + 1);

            if (isPalindrome(substr)) {
                current.add(substr);

                backtrack(i + 1, s, current, result);

                current.remove(current.size() - 1);
            }
        }
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
