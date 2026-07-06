class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];
            indegree[course]++;
            graph.get(prerequisite).add(course);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                int current = queue.poll();

                result.add(current);

                for (int course : graph.get(current)) {
                    indegree[course]--;
                    if (indegree[course] == 0) {
                        queue.add(course);
                    }
                }
            }
        }

        return result.size() == numCourses ? result.stream().mapToInt(Integer::intValue).toArray() : new int[0];
    }
}
