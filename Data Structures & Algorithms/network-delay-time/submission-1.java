class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int weight = time[2];

            graph.get(from).add(new int[]{to, weight});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        boolean[] visited = new boolean[n + 1];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(el -> el[1]));
        dist[k] = 0;
        pq.add(new int[]{k, 0});

        int visitedCount = 0;
        int time = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int currVal = current[0];
            int currDist = current[1];

            if (visited[currVal]) continue;

            visited[currVal] = true;
            visitedCount++;
            time = currDist;

            for (int[] edge : graph.get(currVal)) {
                int nextVal = edge[0];
                int newDist = currDist + edge[1];

                if (!visited[nextVal] && newDist < dist[nextVal]) {
                    dist[nextVal] = newDist;
                    pq.add(new int[]{nextVal, newDist});
                }
            }
        }

        return visitedCount == n ? time : -1;
    }
}
