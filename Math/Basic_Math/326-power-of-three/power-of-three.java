class Solution {
    /**
     * Approach II : Using Math Approach
     *
     * TC: O(1)
     * SC: O(1)
     */
    public boolean isPowerOfThree(int n) {
        int maxPow = (int) Math.pow(3, 19); // this fits in 32 bit integer
        return n > 0 && maxPow % n == 0;
    }

    /**
     * Approach I : Using Math Approach
     *
     * TC: O(log(N) Base 3)
     * SC: O(1)
     */
    public boolean isPowerOfThreeUsingMath(int n) {
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
