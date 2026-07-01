class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());
        for (int stone : stones) {
            queue.add(stone);
        }
        while (queue.size() > 1) {
            int x = queue.poll();
            int y = queue.poll();
            if (x == y) {
                continue;
            }
            queue.add(Math.abs(x - y));
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }
}
