class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > max) max = piles[i];
        }

        int left = 1;
        int right = max;
        int result = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int hours = 0;
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }
            if (hours <= h) {
                result = mid;
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }

        return result;
    }
}
