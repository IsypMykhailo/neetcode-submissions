class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n];

        int visitedCount = dfs(0, graph, visited);

        return visitedCount == n;
    }

    private int dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        if (visited[node]) return 0;

        visited[node] = true;
        int count = 1;

        for (int neighbor : graph.get(node)) {
            count += dfs(neighbor, graph, visited);
        }

        return count;
    }
}
