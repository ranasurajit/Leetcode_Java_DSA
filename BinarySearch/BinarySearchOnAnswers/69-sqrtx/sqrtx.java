class Solution {
    /**
     * Approach : Binary Search on Answers Approach
     *
     * TC: O(log(X))
     * SC: O(1)
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long low = 1;
        long high = x;
        while (low <= high) { // TC: O(log(X))
            long mid = low + (high - low) / 2;
            if (mid * mid > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) high;
    }
}
