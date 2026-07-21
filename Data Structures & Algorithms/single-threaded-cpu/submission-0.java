class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] sortedTasks = new int[n][3];

        for (int i = 0; i < n; i++) {
            sortedTasks[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(sortedTasks, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            Comparator.comparingInt((int[] task) -> task[1]).thenComparingInt(task -> task[2]));
        int[] result = new int[n];
        int taskIndex = 0;
        int resultIndex = 0;
        long currentTime = 0;


        while (resultIndex < n) {
            if (queue.isEmpty() && currentTime < sortedTasks[taskIndex][0]) {
                currentTime = sortedTasks[taskIndex][0];
            }

            while (taskIndex < n && sortedTasks[taskIndex][0] <= currentTime) {
                queue.add(sortedTasks[taskIndex]);
                taskIndex++;
            }

            int[] currentTask = queue.poll();
            result[resultIndex++] = currentTask[2];
            currentTime += currentTask[1];
        }

        return result;
    }
}