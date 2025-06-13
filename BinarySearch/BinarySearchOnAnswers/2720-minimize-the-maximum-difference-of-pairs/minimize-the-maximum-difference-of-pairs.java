class Solution {
    /**
     * Approach : Using Binary Search on Answers Approach
     *
     * TC: O(2 x N x log(N)) ~ O(N x log(N))
     * SC: O(1)
     */
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums); // TC: O(N x log(N))
        int low = 0;
        int high = nums[n - 1] - nums[0]; // maximum difference
        while (low <= high) { // TC: O(log(N))
            int mid = low + (high - low) / 2;
            int countPairs = getPairsPossibleWithDifference(nums, n, mid); // TC: O(N)
            if (countPairs >= p) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * Using Simulation Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    private int getPairsPossibleWithDifference(int[] nums, int n, int diff) {
        int countPairs = 0;
        for (int i = 1; i < n; i++) { // TC: O(N)
            if (nums[i] - nums[i - 1] <= diff) {
                countPairs++;
                i++;
            }
        }
        return countPairs;
    }
}
