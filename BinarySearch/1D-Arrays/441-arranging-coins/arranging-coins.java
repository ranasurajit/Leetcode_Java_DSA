class Solution {
    public int arrangeCoins(int n) {
        if (n == 1) {
            return 1;
        }
        long low = 1;
        long high = n;
        long complete = Long.MIN_VALUE;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long coins = (mid * (mid + 1)) / 2;
            if (coins == n) {
                return (int) mid;
            } else if (coins < n) {
                low = mid + 1;
                complete = Math.max(complete, mid);
            } else {
                high = mid - 1;
            }
        }
        return (int) complete;
    }
}
