class Solution {
    public int maxArea(int[] heights) {
        int max = 0;

        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int length = right - left;
            int width = Math.min(heights[left], heights[right]);
            int area = length * width;
            if (area > max) {
                max = area;
            }

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
