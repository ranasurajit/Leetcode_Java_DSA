class Solution {
    /**
     * Approach II : Optimal Approach (Binary Search)
     *
     * TC: O(N + N x log(M)) ~ O(N x log(M))
     * SC: O(1)
     *
     * where M = Max(candies)
     */
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        long sumCandies = 0;
        int maxCandies = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            sumCandies += candies[i];
            maxCandies = Math.max(maxCandies, candies[i]);
        }
        // if sumCandies is less than number of children 'k' then return 0
        if (sumCandies < k) {
            return 0;
        }
        // we will try to allocate maximum candies possible to k children
        int low = 1;
        int high = maxCandies;
        int result = 0;
        while (low <= high) { // TC: O(log(M)), where M = Max(candies)
            int mid = low + (high - low) / 2;
            if (allocatedCount(candies, n, mid) >= k) { // TC: O(N)
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     */
    private long allocatedCount(int[] candies, int n, int mid) {
        long count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            count += candies[i] / mid;
        }
        return count;
    }

    /**
     * Approach I : Brute-Force Approach (Linear Search)
     *
     * TC: O(N + M x N) ~ O(M x N)
     * SC: O(1)
     *
     * where M = Max(candies)
     */
    public int maximumCandiesApproachI(int[] candies, long k) {
        int n = candies.length;
        int sumCandies = 0;
        int maxCandies = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            sumCandies += candies[i];
            maxCandies = Math.max(maxCandies, candies[i]);
        }
        // if sumCandies is less than number of children 'k' then return 0
        if (sumCandies < k) {
            return 0;
        }
        // we will try to allocate maximum candies possible to k children
        for (int p = maxCandies; p >= 1; p--) { // TC: O(M), where M = Max(candies)
            int countChildren = 0;
            for (int i = 0; i < n; i++) { // TC: O(N)
                countChildren += candies[i] / p;
            }
            if (countChildren >= k) {
                return p;
            }
        }
        return 0;
    }
}
