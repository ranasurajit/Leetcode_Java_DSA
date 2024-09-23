class Solution {
    /**
     * TC: O(log(N))
     * SC: O(1)
     */
    public int arrangeCoins(int n) {
        if (n == 1) {
            return 1;
        }
        long low = 1L;
        long high = (long) n;
        long completed = Long.MIN_VALUE;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long coins = coinsNeeded(mid);
            if (n == coins) {
                return (int) mid;
            } else if (n < coins) {
                high = mid - 1;
            } else {
                low = mid + 1;
                completed = Math.max(completed, mid);
            }
        }
        return (int) completed;
    }

    /**
     * TC: O(1)
     * SC: O(1)
     */
    private long coinsNeeded(long n) {
        return (n * (n + 1)) / 2;
    }
}
