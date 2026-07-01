class KthLargest {
    PriorityQueue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
    }
    
    public int add(int val) {
        queue.add(val);
        int idx = 1;
        List<Integer> removed = new ArrayList();
        while (idx < k) {
            removed.add(queue.poll());
            idx++;
        }
        int kth = queue.peek();
        for (int i = 0; i < removed.size(); i++) {
            queue.add(removed.get(i));
        }

        return kth;
    }
}
