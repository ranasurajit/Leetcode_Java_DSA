class Solution {
    /**
     * Approach II : Optimal Approach (Using Binary Search on Answers)
     *
     * TC: O(N + N x log(K)) ~ O(N x log(K))
     * SC: O(1)
     *
     * where K = Max(ranks) x cars = 100 * 10^6 = 10^8 (1072 / 1072 testcases passed) 
     */
    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length;
        long maxTimeNeeded = 0;
        long minTime = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            maxTimeNeeded = Math.max(maxTimeNeeded, (long) ranks[i] * cars * cars);
        }
        long low = 1;
        long high = maxTimeNeeded;
        while (low <= high) { // TC: O(log(K))
            long mid = low + (high - low) / 2;
            if (isRepairPossible(ranks, n, cars, mid)) { // TC: O(N)
                minTime = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minTime;
    }

    /**
     * Approach I : Brute-Force (Using Linear Search on Answers)
     *
     * TC: O(N + K x N)
     * SC: O(1)
     *
     * where K = Max(ranks) x cars = 100 * 10^6 (TLE - 48 / 1072 testcases passed) 
     */
    public long repairCarsApproachI(int[] ranks, int cars) {
        int n = ranks.length;
        long maxTimeNeeded = 0;
        long minTime = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            maxTimeNeeded = Math.max(maxTimeNeeded, (long) ranks[i] * cars * cars);
        }
        for (long time = 1; time <= maxTimeNeeded; time++) { // TC: O(K)
            if (isRepairPossible(ranks, n, cars, time)) { // TC: O(N)
                minTime = time;
                break;
            }
        }
        return minTime;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     */
    private boolean isRepairPossible(int[] ranks, int n, int cars, long time) {
        long countCars = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            countCars += Math.sqrt(time / ranks[i]);
        }
        return countCars >= cars;
    }
}
