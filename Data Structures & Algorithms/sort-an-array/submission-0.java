class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length == 1) return nums;

        return mergeSort(nums, 0, nums.length - 1);
    }

    private int[] mergeSort(int[] nums, int left, int right) {
        if (left == right) return new int[]{nums[left]};
        int mid = left + (right - left) / 2;
        int[] sortedLeft = mergeSort(nums, left, mid);
        int[] sortedRight = mergeSort(nums, mid + 1, right);
        return merge(sortedLeft, sortedRight);
    }

    private int[] merge(int[] left, int[] right) {
        int[] arr = new int[left.length + right.length];

        int leftIdx = 0;
        int rightIdx = 0;
        int resIdx = 0;

        while (leftIdx < left.length && rightIdx < right.length) {
            if (left[leftIdx] <= right[rightIdx]) {
                arr[resIdx++] = left[leftIdx++];
            } else {
                arr[resIdx++] = right[rightIdx++];
            }
        }

        while (leftIdx < left.length) {
            arr[resIdx++] = left[leftIdx++];
        }

        while (rightIdx < right.length) {
            arr[resIdx++] = right[rightIdx++];
        }

        return arr;
    }
}