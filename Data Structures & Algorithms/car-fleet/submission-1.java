class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> times = new Stack<>();
        Map<Integer, Integer> cars = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < position.length; i++) {
            cars.put(position[i], speed[i]);
        }
        for (Map.Entry<Integer, Integer> car : cars.entrySet()) {
            double time = (double) (target - car.getKey()) / car.getValue();
            if (times.isEmpty() || time > times.peek()) {
                times.push(time);
            }
        }

        return times.size();
    }
}
