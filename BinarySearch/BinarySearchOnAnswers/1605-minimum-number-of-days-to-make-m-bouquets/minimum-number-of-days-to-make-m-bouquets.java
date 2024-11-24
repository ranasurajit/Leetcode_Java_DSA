class Solution {
    /**
     * Optimal Approach - Binary Search
     * 
     * TC: O(N + N x log(Max(bloomDay) - Min(bloomDay))) 
     *   ~ O(N x log(Max(bloomDay) - Min(bloomDay)))
     * SC: O(1)
     * 
     * @param bloomDay
     * @param m
     * @param k
     * @return
     */
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long total = (long) m * (long) k;
        if (total > n) {
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int day : bloomDay) { // TC: O(N)
            low = Math.min(low, day);
            high = Math.max(high, day);
        }
        int minVal = high;
        while (low <= high) { // TC: O(log(Max(bloomDay) - Min(bloomDay)))
            int mid = low + (high - low) / 2;
            int numBouquets = numBouquetsFormed(bloomDay, mid, k); // TC: O(N)
            if (numBouquets >= m) {
                minVal = Math.min(minVal, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minVal;
    }

    /**
     * Brute-Force Approach
     * 
     * TC: O(N + N ^ 2) ~ O(N ^ 2)
     * SC: O(1)
     * 
     * @param bloomDay
     * @param m
     * @param k
     * @return
     */
    public int minDaysBruteForce(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long total = (long) m * (long) k;
        if (total > n) {
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int day : bloomDay) { // TC: O(N)
            low = Math.min(low, day);
            high = Math.max(high, day);
        }
        int minVal = high;
        for (int i = high; i >= low; i--) { // TC: O(N)
            if (numBouquetsFormed(bloomDay, i, k) >= m) { // TC: O(N)
                minVal = Math.min(minVal, i);
            }
        }
        return minVal;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     * 
     * @param bloomDay
     * @param minDay
     * @param k
     * @return
     */
    private int numBouquetsFormed(int[] bloomDay, int minDay, int k) {
        int count = 0;
        int numBouquets = 0;
        for (int day : bloomDay) { // TC: O(N)
            if (day <= minDay) {
                count++;
            } else {
                numBouquets += count / k;
                count = 0;
            }
        }
        numBouquets += count / k;
        return numBouquets;
    }
}
