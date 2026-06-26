class Solution {
    public String minWindow(String s, String t) {
        String result = "";

        Map<Character, Integer> freqS = new HashMap<>();
        Map<Character, Integer> freqT = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            freqT.put(c, freqT.getOrDefault(c, 0) + 1);
        }

        int required = freqT.size();
        int formed = 0;

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int resultStart = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            if (freqT.containsKey(rightChar)) {
                freqS.put(rightChar, freqS.getOrDefault(rightChar, 0) + 1);

                if (freqS.get(rightChar).equals(freqT.get(rightChar))) {
                    formed++;
                }
            }

            while (formed == required) {
                int windowLength = right - left + 1;

                if (windowLength < minLength) {
                    minLength = windowLength;
                    resultStart = left;
                }

                char leftChar = s.charAt(left);

                if (freqT.containsKey(leftChar)) {
                    freqS.put(leftChar, freqS.get(leftChar) - 1);

                    if (freqS.get(leftChar) < freqT.get(leftChar)) {
                        formed--;
                    }
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(resultStart, resultStart + minLength);
    }
}
