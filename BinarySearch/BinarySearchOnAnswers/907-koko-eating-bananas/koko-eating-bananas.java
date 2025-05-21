class Solution {
    /**
     * Approach : Using Binary Search on Answers Approach
     * 
     * TC:  O(N + N x log(Max(piles[i]))) ~ O(N x log(Max(piles[i])))
     * SC: O(1)
     */
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        long low = 1;
        long high = Integer.MIN_VALUE;
        // low is the minimum number of bananas Koko should finish in an hour
        // high is the maximum number of bananas Koko needs to finish in an hour
        for (int i = 0; i < n; i++) { // TC: O(N)
            high = (long) Math.max(high, piles[i]);
        }
        // Applying Binary Search
        long minSpeed = high;
        while (low <= high) { // TC: O(log(Max(piles[i])))
            long mid = low + (high - low) / 2;
            // mid value is likely to be the minimum speed at which Koko should eat the bananas
            if (countFinishedBanans(piles, n, mid) <= h) { // TC: O(N)
                minSpeed = Math.min(minSpeed, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) minSpeed;
    }

    /**
     * Return the count of bananas that can be finished at a speed of 'mid' bananas / hour
     *
     * TC: O(N)
     * SC: O(1)
     */
    private long countFinishedBanans(int[] piles, int n, long mid) {
        long count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            count += piles[i] % mid == 0 ? piles[i] / mid : (piles[i] / mid) + 1;
        }
        return count;
    }
}
