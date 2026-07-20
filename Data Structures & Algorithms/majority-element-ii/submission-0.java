class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int desiredFreq = n / 3;
        List<Integer> result = new ArrayList<>();

        int candidate1 = Integer.MAX_VALUE;
        int candidate2 = Integer.MAX_VALUE;
        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        if (count1 > desiredFreq) {
            result.add(candidate1);
        }

        if (count2 > desiredFreq) {
            result.add(candidate2);
        }

        return result;
    }
}