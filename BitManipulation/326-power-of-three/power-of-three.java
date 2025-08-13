class Solution {
    /**
     * Approach : Using Math Approach
     *
     * TC: O(log(N) Base 3)
     * SC: O(1)
     */
    public boolean isPowerOfThree(int n) {
        int rem = 0;
        int maxRem = 0;
        while (n > 0) { // TC: O(log(N) Base 3)
            rem = n % 3;
            if (rem != 0 && n > 1) {
                return false;
            }
            maxRem = Math.max(maxRem, rem);
            n = n / 3;
        }
        return maxRem == 1;
    }
}
