class Solution {
    /**
     * Approach II : Optimal Approach (Using Binary Search on Answers)
     *
     * TC: O(N + N x log(K)) ~ O(N x log(K))
     * SC: O(1)
     *
     * where K = Min(ranks) x cars = 100 * 10^6 = 10^8 (1072 / 1072 testcases passed) 
     */
    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length;
        long minRank = Integer.MAX_VALUE;
        long minTime = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            minRank = Math.min(minRank, ranks[i]);
        }
        // Using Binary Search on Answers
        long low = 1;
        // as the mechanic with best rank can repair all cars
        long high = minRank * cars * cars;
        while (low <= high) { // TC: O(log(K))
            long mid = low + (high - low) / 2;
            if (isRepairPossible(ranks, n, cars, mid)) { // TC: O(N)
                minTime = mid; // probable answer
                high = mid - 1; // shrink the size to get best answer
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
     * where K = Min(ranks) x cars = 100 * 10^6 (TLE - 47 / 1072 testcases passed) 
     */
    public long repairCarsApproachI(int[] ranks, int cars) {
        int n = ranks.length;
        long minRank = Integer.MAX_VALUE;
        long minTime = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            minRank = Math.min(minRank, ranks[i]);
        }
        // time max value is minTimeNeeded as the mechanic with best rank can repair all cars
        long maxTime = minRank * cars * cars;
        for (long time = 1; time <= maxTime; time++) { // TC: O(K)
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
