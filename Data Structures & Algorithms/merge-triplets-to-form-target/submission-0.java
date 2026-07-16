class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        for (int i = 0; i < triplets.length; i++) {
            if (triplets[i][0] > target[0] || triplets[i][1] > target[1] || triplets[i][2] > target[2]) {
                triplets[i][0] = -1;
                triplets[i][1] = -1;
                triplets[i][2] = -1;
            }
        }

        boolean foundFirst = false;
        boolean foundSecond = false;
        boolean foundThird = false;
        for (int[] triplet : triplets) {
            if (triplet[0] == target[0]) foundFirst = true;
            if (triplet[1] == target[1]) foundSecond = true;
            if (triplet[2] == target[2]) foundThird = true;
        }

        return foundFirst && foundSecond && foundThird;
    }
}
