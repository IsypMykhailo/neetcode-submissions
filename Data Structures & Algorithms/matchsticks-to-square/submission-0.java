class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) return false;

        int totalLength = 0;

        for (int matchstick : matchsticks) {
            totalLength += matchstick;
        }

        if (totalLength % 4 != 0) return false;

        int target = totalLength / 4;

        Arrays.sort(matchsticks);

        for (int left = 0, right = matchsticks.length - 1; left < right; left++, right--) {
            int temp = matchsticks[left];
            matchsticks[left] = matchsticks[right];
            matchsticks[right] = temp;
        }

        if (matchsticks[0] > target) return false;

        int[] sides = new int[4];

        return backtrack(matchsticks, 0, sides, target);
    }

    private boolean backtrack(int[] matchsticks, int i, int[] sides, int target) {
        if (i == matchsticks.length) {
            return true;
        }

        int currentMatchstick = matchsticks[i];

        for (int side = 0; side < 4; side++) {
            if (sides[side] + currentMatchstick > target) {
                continue;
            }
            if (side > 0 && sides[side] == sides[side - 1]) {
                continue;
            }

            sides[side] += currentMatchstick;

            if (backtrack(matchsticks, i + 1, sides, target)) {
                return true;
            }

            sides[side] -= currentMatchstick;
        }

        return false;
    }
}