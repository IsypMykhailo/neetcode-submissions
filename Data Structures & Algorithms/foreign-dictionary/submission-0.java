class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            int shorterLength = Math.min(word1.length(), word2.length());
            boolean foundDifference = false;

            for (int j = 0; j < shorterLength; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }

                    foundDifference = true;
                    break;
                }
            }

            if (!foundDifference && word1.length() > word2.length()) {
                return "";
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.add(c);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            char current = queue.poll();
            result.append(current);

            for (char next : graph.get(current)) {
                indegree.put(next, indegree.get(next) - 1);

                if (indegree.get(next) == 0) {
                    queue.add(next);
                }
            }
        }

        if (result.length() != indegree.size()) {
            return "";
        }

        return result.toString();
    }
}
