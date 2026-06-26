class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        Map<Character, Integer> s1Freq = new HashMap();
        Map<Character, Integer> s2Freq = new HashMap();
        int left = 0;
        for (int i = 0; i < s1.length(); i++) {
            s1Freq.put(s1.charAt(i), s1Freq.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for (int right = 0; right < s2.length(); right++) {
            s2Freq.put(s2.charAt(right), s2Freq.getOrDefault(s2.charAt(right), 0) + 1);
            int windowSize = right - left + 1;
            if (windowSize > s1.length()) {
                s2Freq.put(s2.charAt(left), s2Freq.get(s2.charAt(left)) - 1);

                if (s2Freq.get(s2.charAt(left)) == 0) {
                    s2Freq.remove(s2.charAt(left));
                }

                left++;
            }
            if (windowSize >= s1.length() && s1Freq.equals(s2Freq)) {
                return true;
            }
        }

        return false;
    }
}
