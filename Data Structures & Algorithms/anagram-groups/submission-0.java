class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();

        Set<String> seen = new HashSet();

        for (int i = 0; i < strs.length; i++) {
            if (seen.contains(strs[i])) {
                continue;
            }
            List<String> group = new ArrayList();
            group.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagram(strs[i], strs[j])) {
                    group.add(strs[j]);
                    seen.add(strs[j]);
                }
            }
            result.add(group);
        }

        return result;
    }

    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> freq = new HashMap();

        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (!freq.containsKey(t.charAt(i))) {
                return false;
            }

            freq.put(t.charAt(i), freq.get(t.charAt(i)) - 1);

            if (freq.get(t.charAt(i)) == 0) {
                freq.remove(t.charAt(i));
            }
        }

        return freq.size() == 0;
    }
}
