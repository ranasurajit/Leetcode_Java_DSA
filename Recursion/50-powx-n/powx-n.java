class Solution {
    /**
     * Using Recursion Approach
     * 
     * TC: O(log(N))
     * SC: O(log(N))
     * 
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / pow(x, -1 * n);
        }
        return pow(x, n);
    }

    /**
     * Using Recursion
     * 
     * TC: O(log(N))
     * SC: O(log(N))
     * 
     * @param x
     * @param n
     * @return
     */
    private double pow(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (x == 1.0 || n == 0) {
            return 1.0;
        }
        double answer = pow(x, n / 2);
        if ((n & 1) == 0) {
            // n is even
            return answer * answer;
        } else {
            // n is odd
            return x * answer * answer;
        }
    }
}
