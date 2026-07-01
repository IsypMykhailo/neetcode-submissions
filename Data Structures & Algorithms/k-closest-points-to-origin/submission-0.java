class Solution {
    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        double getDistanceFromOrigin() {
            return Math.sqrt(x * x + y * y);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> queue = new PriorityQueue(Comparator.comparingDouble(Point::getDistanceFromOrigin));
        
        for (int[] point : points) {
            queue.add(new Point(point[0], point[1]));
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            Point p = queue.poll();
            int[] point = {p.x, p.y};
            result[i] = point;
        }

        return result;
    }
}
