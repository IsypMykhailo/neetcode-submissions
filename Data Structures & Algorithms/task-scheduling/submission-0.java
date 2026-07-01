class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];
        for (char task : tasks) {
            int pos = task - 'A';
            freqs[pos]++;
        }

        PriorityQueue<Integer> freqsQueue = new PriorityQueue(Collections.reverseOrder());
        for (int freq : freqs) {
            if (freq > 0) {
                freqsQueue.add(freq);
            }
        }

        int time = 0;

        while (!freqsQueue.isEmpty()) {
            List<Integer> temp = new ArrayList();

            for (int i = 0; i <= n; i++) {
                if (!freqsQueue.isEmpty()) {
                    int freq = freqsQueue.poll();
                    freq--;

                    if (freq > 0) {
                        temp.add(freq);
                    }
                }

                time++;

                if (freqsQueue.isEmpty() && temp.isEmpty()) break;
            }

            for (int freq : temp) {
                freqsQueue.add(freq);
            }
        }

        return time;
    }
}
