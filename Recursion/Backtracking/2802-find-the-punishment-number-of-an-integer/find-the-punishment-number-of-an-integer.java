class Solution {
    /**
     * TC: O(N x log10(2^(N^2)))
     * SC: O(log10(2^(N^2)))
     */
    public int punishmentNumber(int n) {
        int punishment = 0;
        for (int i = 1; i <= n; i++) { // TC: O(N)
            int sq = i * i;
            if (checkIfValid(sq, 0, i)) {
                punishment += sq;
            }
        }
        return punishment;
    }

    private boolean checkIfValid(int square, int sum, int target) {
        if (square == 0) {
            return sum == target;
        }
        return checkIfValid(square/10, sum + square % 10, target) ||
            checkIfValid(square/100, sum + square % 100, target) ||
            checkIfValid(square/1000, sum + square % 1000, target) ||
            checkIfValid(square/10000, sum + square % 10000, target);
    }
}
