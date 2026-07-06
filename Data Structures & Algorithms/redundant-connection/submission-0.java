class Solution {
    private int[] parent;
    private int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        rank = new int[edges.length + 1];
        List<int[]> unconnected = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            boolean connected = union(u, v);

            if (!connected) {
                unconnected.add(edge);
            }
        }

        return unconnected.get(unconnected.size() - 1);
    }

    private int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    private boolean union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV) return false;

        if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }

        return true;
    }
}
