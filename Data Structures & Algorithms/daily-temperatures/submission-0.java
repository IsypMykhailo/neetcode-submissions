class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> indices = new Stack<>();
        indices.push(0);

        for (int i = 1; i < temperatures.length; i++) {
            while (!indices.isEmpty() && temperatures[i] > temperatures[indices.peek()]) {
                int element = indices.pop();
                result[element] = i - element;
            }
            indices.push(i);
        }

        return result;
    }
}
