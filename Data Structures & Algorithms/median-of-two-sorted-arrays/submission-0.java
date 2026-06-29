class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] smaller;
        int[] bigger;
        if (nums1.length <= nums2.length) {
            smaller = nums1;
            bigger = nums2;
        } else {
            smaller = nums2;
            bigger = nums1;
        }

        int m = smaller.length;
        int n = bigger.length;

        int total = m + n;
        int half = (total + 1) / 2;

        int left = 0;
        int right = m;

        while (left <= right) {
            int partitionSmall = left + (right - left) / 2;
            int partitionBig = half - partitionSmall;

            int smallLeft = partitionSmall == 0 ? Integer.MIN_VALUE : smaller[partitionSmall - 1];

            int smallRight = partitionSmall == m ? Integer.MAX_VALUE : smaller[partitionSmall];

            int bigLeft = partitionBig == 0 ? Integer.MIN_VALUE : bigger[partitionBig - 1];

            int bigRight = partitionBig == n ? Integer.MAX_VALUE : bigger[partitionBig];

            if (smallLeft <= bigRight && bigLeft <= smallRight) {
                if (total % 2 == 1) {
                    return Math.max(smallLeft, bigLeft);
                } else {
                    int leftMax = Math.max(smallLeft, bigLeft);
                    int rightMin = Math.min(smallRight, bigRight);

                    return (leftMax + rightMin) / 2.0;
                }
            } else if (smallLeft > bigRight) {
                right = partitionSmall - 1;
            } else {
                left = partitionSmall + 1;
            }
        }

        return -1;
    }
}
