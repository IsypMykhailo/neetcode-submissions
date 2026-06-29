class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = -1;
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] <= target && target <= matrix[mid][matrix[mid].length - 1]) {
                row = mid;
                break;
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (row == -1) {
            return false;
        }

        left = 0;
        right = matrix[row].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
