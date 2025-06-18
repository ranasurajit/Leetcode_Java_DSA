class Solution {
    /**
     * Using Recursion Approach
     * 
     * TC: O(log(N))
     * SC: O(log(N))
     */
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / fastPower(x, -1 * (long) n);
        }
        return fastPower(x, (long) n);
    }

    /**
     * Using Recursion Approach
     * 
     * TC: O(log(N))
     * SC: O(log(N))
     */
    private double fastPower(double x, long n) {
        // Base Case
        if (n == 0) {
            return 1.0;
        }
        // Recursion Calls
        double half = fastPower(x, n / 2);
        double answer = half * half;
        if ((n % 2) == 1) {
            // n is odd
            return x * answer;
        }
        return answer;
    }
}
