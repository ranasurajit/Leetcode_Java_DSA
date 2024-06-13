class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / pow(x, -n);
        }
        return pow(x, n);
    }

    private double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double ans = pow(x, n / 2);
        if ((n & 1) == 0) {
            // n is even
            return ans * ans;
        } else {
            // n is odd
            return x * ans * ans;
        }
    }
}
