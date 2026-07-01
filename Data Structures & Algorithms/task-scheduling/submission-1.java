class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];

        for (char task : tasks) {
            freqs[task - 'A']++;
        }

        int maxFreq = 0;
        int maxCount = 0;

        for (int freq : freqs) {
            if (freq > maxFreq) {
                maxFreq = freq;
                maxCount = 1;
            } else if (freq == maxFreq) {
                maxCount++;
            }
        }

        int partCount = maxFreq - 1;
        int partLength = n + 1;

        int minTime = partCount * partLength + maxCount;

        return Math.max(tasks.length, minTime);
    }
}
