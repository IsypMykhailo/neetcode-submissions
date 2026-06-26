class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            freq[rightChar - 'A']++;

            maxFreq = Math.max(maxFreq, freq[rightChar - 'A']);

            int windowLength = right - left + 1;

            if (windowLength - maxFreq > k) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'A']--;
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
