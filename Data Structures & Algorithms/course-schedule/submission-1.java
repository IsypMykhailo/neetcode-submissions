class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];

            graph.get(prerequisite).add(course);
        }

        int[] state = new int[numCourses];

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, graph, state)) return false;
        }

        return true;
    }

    private boolean dfs(int course, List<List<Integer>> graph, int[] state) {
        if (state[course] == 1) return false;

        if (state[course] == 2) return true;

        state[course] = 1;

        for (int nextCourse : graph.get(course)) {
            if (!dfs(nextCourse, graph, state)) return false;
        }

        state[course] = 2;

        return true;
    }
}
