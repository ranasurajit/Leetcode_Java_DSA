class Solution {
    /**
     * Optimal Approach
     * 
     * TC: O(N x log(K)), where K = Maximum value in piles array
     * SC: O(1)
     * 
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getMax(piles);
        int minSpeed = Integer.MAX_VALUE;
        while (low <= high) { // TC: O(log(K))
            int mid = low + (high - low) / 2;
            if (calculateTotalHours(piles, mid) <= h) { // TC: O(N)
                minSpeed = Math.min(minSpeed, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minSpeed;
    }

    /**
     * TC: O(K x N), where K = Maximum value in piles array
     * SC: O(1)
     * 
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeedBruteForce(int[] piles, int h) {
        int low = 1;
        int high = getMax(piles);
        int minSpeed = Integer.MAX_VALUE;
        for (int i = low; i <= high; i++) {
            if ((int) calculateTotalHours(piles, i) <= h) {
                minSpeed = Math.min(minSpeed, i);
            }
        }
        return minSpeed;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     * 
     * @param piles
     * @param current
     * @return
     */
    private static long calculateTotalHours(int[] piles, int current) {
        long sum = 0L;
        for (int pile : piles) {
            sum += pile % current == 0 ? (pile / current) : (pile / current) + 1;
        }
        return sum;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     * 
     * @param piles
     * @return
     */
    private static int getMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}
