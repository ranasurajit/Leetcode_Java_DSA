class Solution {
    /**
     * Approach : Using Recursion Approach
     *
     * TC: O(log(N) Base 2)
     * SC: O(log(N) Base 2)
     */
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / fastPower(x, -1 * n);
        }
        return fastPower(x, n);
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(log(N) Base 2)
     * SC: O(log(N) Base 2)
     */
    private double fastPower(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double ans = fastPower(x, n / 2);
        double result = ans * ans;
        if ((n & 1) != 0) {
            result = result * x;
        }
        return result;
    }
}
