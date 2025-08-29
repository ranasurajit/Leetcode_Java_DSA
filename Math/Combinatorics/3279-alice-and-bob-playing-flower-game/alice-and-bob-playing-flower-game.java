class Solution {
    /**
     * Approach : Using Math Approach
     *
     * TC: O(1)
     * SC: O(1)
     */
    public long flowerGame(int n, int m) {
        long oddN = 0L;
        long evenN = 0L;
        /**
         * Alice will win if total number of flowers x + y = odd 
         * which is possible if 
         * 1. x is even and y is odd 
         * 2. x is odd and y is even
         */
        if ((n & 1) == 0) {
            // n is even
            oddN = n / 2;
            evenN = n / 2;
        } else {
            // n is odd
            oddN = (n / 2) + 1;
            evenN = n / 2;
        }
        int oddM = 0;
        int evenM = 0;
        if ((m & 1) == 0) {
            // m is even
            oddM = m / 2;
            evenM = m / 2;
        } else {
            // m is odd
            oddM = (m / 2) + 1;
            evenM = m / 2;
        }
        long result = (oddN * evenM) + (oddM * evenN);
        return result;
    }
}
