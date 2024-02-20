class Solution {
    public double myPow(double x, int n) {
        return helper(x, n);
    }

    private double helper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double temp = helper(x, (n / 2));
        if ((n & 1) == 0) {
            // even pow
            return temp * temp;
        } else {
            // odd pow
            return x * temp * temp;
        }
    }
}
