class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();

        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            PriorityQueue<String> queue = map.getOrDefault(from, new PriorityQueue<>());
            queue.add(to);
            map.put(from, queue);
        }

        dfs("JFK", map, result);

        return result;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> map, List<String> result) {
        PriorityQueue<String> queue = map.get(airport);

        while (queue != null && !queue.isEmpty()) {
            String next = queue.poll();
            dfs(next, map, result);
        }

        result.addFirst(airport);
    }
}
