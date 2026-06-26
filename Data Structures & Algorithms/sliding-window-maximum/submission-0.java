class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());
        int[] result = new int[nums.length - k + 1];
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            queue.add(nums[right]);

            int windowLength = right - left + 1;
            
            if (windowLength == k) {
                result[left] = queue.peek();

                queue.remove(nums[left]);
                left++;
            }
        }

        return result;
    }
}
