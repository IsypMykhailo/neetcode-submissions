class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            while(seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(s.charAt(right));
            int length = right - left + 1;
            if (length > max) {
                max = length;
            }
            right++;
        }

        return max;
    }
}
