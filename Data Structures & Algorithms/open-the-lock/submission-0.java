class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendsSet = new HashSet<>();
        for (String deadend : deadends) {
            deadendsSet.add(deadend);
        }

        if (deadendsSet.contains("0000")) return -1;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int turns = 0;
        queue.add("0000");

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String currentComb = queue.poll();
                if (currentComb.equals(target)) return turns;

                visited.add(currentComb);

                for (int wheel = 0; wheel < currentComb.length(); wheel++) {
                    char[] digits = currentComb.toCharArray();
                    char originalDigit = digits[wheel];

                    digits[wheel] =
                        originalDigit == '9'
                            ? '0'
                            : (char) (originalDigit + 1);

                    String nextComb = new String(digits);

                    if (!deadendsSet.contains(nextComb)
                            && visited.add(nextComb)) {
                        queue.add(nextComb);
                    }

                    digits[wheel] =
                        originalDigit == '0'
                            ? '9'
                            : (char) (originalDigit - 1);

                    nextComb = new String(digits);

                    if (!deadendsSet.contains(nextComb)
                            && visited.add(nextComb)) {
                        queue.add(nextComb);
                    }
                }
            }
            turns++;
        }

        return -1;
    }
}