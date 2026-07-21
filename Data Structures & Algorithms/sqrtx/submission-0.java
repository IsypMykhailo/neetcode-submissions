class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int low = 1;
        int high = x / 2;
        int result = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid <= x / mid) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}