class Solution {
    /**
     * Using Recursion + Memoization
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> sums = new ArrayList<Integer>();
        int[][] dp = new int[nums.length + 1][4];
        for (int[] dp1D: dp) {
            Arrays.fill(dp1D, -1);
        }
        getSubarraySumOfK(nums, sums, k); // TC: O(N), SC: O(1)
        int count = 3; // 3 Non-Overlapping Subarrays needed
        solve(0, 3, k, sums, result, dp); // TC: O(N x M) by memoization, M = 3 ~ O(N)
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * This method is intended to return the pre-computed sliding window sum of size k
     * 
     * TC: O(N)
     * SC: O(1)
     */
    private void getSubarraySumOfK(int[] nums, List<Integer> sums, int k) {
        int i = 0; // start index of sliding window
        int j = 0; // end index of sliding window
        int n = nums.length;
        int sum = 0;
        while (j < n) {
            sum += nums[j];
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                // sliding window size reached k
                sums.add(sum);
                // remove calculation from ith index and slide the window to maintain size k
                sum -= nums[i];
                i++;
                j++;
            }
        }
    }

    /**
     * This method is intended to return the starting indices of our choice
     *
     * TC: O(N x M) ~ O(N)
     * SC: O(N x M) ~ O(N)
     */
    private void solve(int index, int count, int k, List<Integer> sums,
        List<Integer> result, int[][] dp) {
        // Base case
        if (count == 0 || index >= sums.size()) {
            return;
        }
        int takeSum = sums.get(index) + helperSum(sums, index + k, count - 1, k, dp);
        int notTakeSum = helperSum(sums, index + 1, count, k, dp);
        // since we need to take lexicographically smallest index
        if (takeSum >= notTakeSum) {
            result.add(index);
            solve(index + k, count - 1, k, sums, result, dp);
        } else {
            solve(index + 1, count, k, sums, result, dp);
        }
    }

    /**
     * This method is intended to return the maximum sum obtained from a starting index
     *
     * TC: O(N x M) ~ O(N)
     * SC: O(N x M) ~ O(N)
     */
    private int helperSum(List<Integer> sums, int index, int count, int k, int[][] dp) {
        // Base case
        if (count == 0) {
            return 0;
        }
        if (index >= sums.size()) {
            // never got all the indices for 3 non-overlapping sub-arrays
            return Integer.MIN_VALUE;
        }
        if (dp[index][count] != -1) {
            return dp[index][count];
        }
        int take = sums.get(index) + helperSum(sums, index + k, count - 1, k, dp);
        int notTake = helperSum(sums, index + 1, count, k, dp);
        dp[index][count] = Math.max(take, notTake);
        return dp[index][count];
    }
}
