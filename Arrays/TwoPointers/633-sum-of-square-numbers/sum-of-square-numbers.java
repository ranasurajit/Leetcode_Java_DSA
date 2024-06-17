class Solution {
    public boolean judgeSquareSum(int c) {
        double p = 0;
        double q = Math.floor(Math.sqrt(c));
        while (p <= q) {
            double prod = (p * p) + (q * q);
            if (prod == (double) c) {
                return true;
            } else if (prod < (double) c) {
                p++;
            } else {
                q--;
            }
        }
        return false;
    }
}
