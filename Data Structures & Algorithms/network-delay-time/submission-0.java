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

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(el -> el[1]));
        dist[k] = 0;
        pq.add(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int currVal = current[0];
            int currDist = current[1];

            if (currDist > dist[currVal]) continue;

            for (int[] edge : graph.get(currVal)) {
                int nextVal = edge[0];
                int newDist = currDist + edge[1];

                if (newDist < dist[nextVal]) {
                    dist[nextVal] = newDist;
                    pq.add(new int[]{nextVal, newDist});
                }
            }
        }

        int time = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            time = Math.max(time, dist[i]);
        }

        return time;
    }
}
