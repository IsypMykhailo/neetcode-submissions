class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {    
        Map<String, List<String>> graph = new HashMap<>();

        for (String word : wordList) {
            putTransformations(word, graph);
        }    
        putTransformations(beginWord, graph);

        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        visited.add(beginWord);
        queue.add(beginWord);

        int currentLevel = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int k = 0; k < levelSize; k++) {
                String current = queue.poll();
                if (current.equals(endWord)) {
                    return currentLevel;
                }
                for (int i = 0; i < current.length(); i++) {
                    String key = current.substring(0, i) + "*" + current.substring(i + 1);
                    List<String> transformations = graph.getOrDefault(key, new ArrayList<>());
                    for (String transformation : transformations) {
                        if (!visited.contains(transformation)) {
                            visited.add(transformation);
                            queue.add(transformation);
                        }
                    }
                }
            }

            currentLevel++;
        }

        return 0;
    }

    private void putTransformations(String word, Map<String, List<String>> graph) {
        for (int i = 0; i < word.length(); i++) {
            String key = word.substring(0, i) + "*" + word.substring(i + 1);

            graph.putIfAbsent(key, new ArrayList<>());
            graph.get(key).add(word);
        }
    }
}
