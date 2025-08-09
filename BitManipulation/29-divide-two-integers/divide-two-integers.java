class Solution {
    /**
     * Approach : Using Math + Simulation Approach
     *
     * TC: O(D)
     * SC: O(1)
     *
     * where D = dividend (in worst case divisor = 1)
     */
    public int divide(int dividend, int divisor) {
        int neg = ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) ? -1 : 1;
        if (Math.abs(divisor) == 1) {
            long res = (long) dividend;
            res = neg * Math.abs(res);
            if (res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return (int) res;
        }
        long dvd = dividend < 0 ? -1 * (long) dividend : (long) dividend;
        long dvs = divisor < 0 ? -1 * (long) divisor : (long) divisor;
        long sum = 0L;
        long result = 0L;
        while (sum + dvs <= dvd) { // TC: O(D)
            result++;
            sum += dvs;
        }
        result = result * neg;
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }
}
