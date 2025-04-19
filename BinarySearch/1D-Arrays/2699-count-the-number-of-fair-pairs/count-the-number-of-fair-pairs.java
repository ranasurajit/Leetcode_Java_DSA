class Solution {
    /**
     * Approach II : Using Binary Search Approach
     *
     * TC: O(2 x N x log(N)) ~ O(N x log(N))
     * SC: O(1)
     *
     * Accepted (54 / 54 testcases passed)
     */
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums); // TC: O(N x log(N))
        long countPairsLower = 0L;
        long countPairsUpper = 0L;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int lowerValue = lower - nums[i];
            countPairsLower += lowerBound(nums, i + 1, n - 1, lowerValue); // TC: O(log(N))
            int upperValue = upper - nums[i];
            countPairsUpper += upperBound(nums, i + 1, n - 1, upperValue); // TC: O(log(N))
        }
        return countPairsUpper - countPairsLower;
    }

    /**
     * Using Binary Search Approach
     * to find x such that nums[i] >= x
     *
     * TC: O(log(N))
     * SC: O(1)
     */
    private int lowerBound(int[] nums, int low, int high, int x) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * Using Binary Search Approach
     * to find x such that nums[i] > x
     *
     * TC: O(log(N))
     * SC: O(1)
     */
    private int upperBound(int[] nums, int low, int high, int x) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * Approach I : Brute-Force Approach
     *
     * TC: O(N ^ 2)
     * SC: O(1)
     *
     * Time Limit Exceeded (47 / 54 testcases passed)
     */
    public long countFairPairsApproachI(int[] nums, int lower, int upper) {
        int n = nums.length;
        long countPairs = 0L;
        for (int i = 0; i < n - 1; i++) { // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                long sum = nums[i] + nums[j];
                if (sum >= lower && sum <= upper) {
                    countPairs++;
                }
            }
        }
        return countPairs;
    }
}
