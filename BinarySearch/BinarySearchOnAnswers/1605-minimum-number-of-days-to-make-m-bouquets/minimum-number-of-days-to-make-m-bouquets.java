class Solution {
    /**
     * Approach : Using Binary Search on Answers Approach
     * 
     * TC: O(N + log(Max(bloomDay) - Min(bloomDay)))
     * SC: O(1)
     * 
     * @param bloomDay
     * @param m
     * @param k
     * @return
     */
    public int minDays(int[] bloomDay, int m, int k) {
        long total = (long) m * (long) k;
        if (bloomDay.length < total) {
            // cannot make 'm' bouquets
            return -1;
        }
        long low = Integer.MAX_VALUE;
        long high = Integer.MIN_VALUE;

        for (int day : bloomDay) { // TC: O(N)
            low = Math.min(low, (long) day);
            high = Math.max(high, (long) day);
        }

        // Applying Binary Search
        long minimumDays = high;
        while (low <= high) { // TC: O(log(Max(bloomDay) - Min(bloomDay)))
            long mid = low + (high - low) / 2;
            if (countBouquetsPossible(bloomDay, k, mid) >= m) { // TC: O(N)
                minimumDays = Math.min(minimumDays, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) minimumDays;
    }

    /**
     * Using Simulation Approach
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * @param bloomDay
     * @param k
     * @param mid
     * @return
     */
    private long countBouquetsPossible(int[] bloomDay, int k, long mid) {
        long count = 0;
        long bouquets = 0;
        for (int day : bloomDay) { // TC: O(N)
            if (day <= mid) {
                count++;
            } else {
                bouquets += (count / k);
                count = 0;
            }
        }
        bouquets += (count / k);
        return bouquets;
    }
}
