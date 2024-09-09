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
        // TC: O(log(N))
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long calc = calculate(mid);
            if (calc == n) {
                return (int) mid;
            } else if (calc > n) {
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
     */
    private long calculate(long k) {
        return (k * (k + 1)) / 2;
    }
}
