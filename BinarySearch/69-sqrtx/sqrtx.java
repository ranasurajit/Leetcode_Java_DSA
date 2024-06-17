class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        long low = 1L;
        long high = (long) x;
        int sqrt = 1;
        while (low <= high) {
            long mid = low + ((high - low) / 2);
            long prod = mid * mid;
            if (prod == x) {
                return (int) mid;
            } else if (prod <= x) {
                sqrt = (int) mid;
                low = mid + 1;
            } else if (prod > x) {
                high = mid - 1;
            }
        }
        return sqrt;
    }
}
