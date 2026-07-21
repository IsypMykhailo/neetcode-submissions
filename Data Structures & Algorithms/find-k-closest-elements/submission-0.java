class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < x)
                low = mid + 1;
            else
                high = mid;
        }

        int left = low - 1;
        int right = low;
        while (right - left - 1 < k) {
            if (left < 0) {
                right++;
            } else if (right >= arr.length) {
                left--;
            } else {
                long leftDistance = Math.abs((long) arr[left] - x);
                long rightDistance = Math.abs((long) arr[right] - x);

                if (leftDistance <= rightDistance) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = left + 1; i < right; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}