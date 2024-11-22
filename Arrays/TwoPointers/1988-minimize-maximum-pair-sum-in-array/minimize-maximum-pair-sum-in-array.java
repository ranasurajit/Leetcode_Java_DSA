class Solution {
    /**
     * Using Two Pointers Approach
     *
     * TC: O(N + N x log(N)) ~ O(N x log(N))
     * SC: O(1)
     *
     * such that ith index will be summed with (n - i - 1)th index
     * value
     */
    public int minPairSum(int[] nums) {
        int n = nums.length;
        /* 
         * To minimize max sum pair, we need to sort it and make pair
         * such that ith index will be summed with (n - i - 1)th index
         * value
         */
        Arrays.sort(nums); // TC: O(N x log(N))
        int p = 0;
        int q = n - 1;
        int maxSum = 0; // as 1 <= nums[i] <= 105
        while (p < q) { // TC: O(N)
            maxSum = Math.max(maxSum, nums[p] + nums[q]);
            p++;
            q--;
        }
        return maxSum;
    }
}
