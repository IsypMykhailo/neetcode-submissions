class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> answer = new ArrayList<>();

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] prereq : prerequisites) {
            graph.computeIfAbsent(prereq[0], key -> new HashSet<>()).add(prereq[1]);
        }

        for (int[] query : queries) {
            Set<Integer> visited = new HashSet<>();
            boolean isPrereq = findIfPrereq(graph, query[0], query[1], visited);
            answer.add(isPrereq);
        }

        return answer;
    }

    private boolean findIfPrereq(Map<Integer, Set<Integer>> graph, int prereq, int target, Set<Integer> visited) {
        if (!visited.add(prereq)) {
            return false;
        }
        if (graph.containsKey(prereq)) {
            if (graph.get(prereq).contains(target)) {
                return true;
            } else {
                boolean isPrereq = false;
                for (int node : graph.get(prereq)) {
                    isPrereq = findIfPrereq(graph, node, target, visited);
                    if (isPrereq) {
                        return true;
                    }
                }
            }
        } else {
            return false;
        }

        return false;
    }
}