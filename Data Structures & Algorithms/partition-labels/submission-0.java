class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> lastIndex = new HashMap<>();
        char[] sChars = s.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            lastIndex.put(sChars[i], i);
        }

        int partitionSize = 0;
        int partitionEnd = 0;
        for (int i = 0; i < sChars.length; i++) {
            partitionSize++;

            partitionEnd = Math.max(partitionEnd, lastIndex.get(sChars[i]));

            if (i == partitionEnd) {
                result.add(partitionSize);
                partitionSize = 0;
            }
        }

        return result;
    }
}
