class Solution {
    /**
     * Approach : Using Greedy + Sorting + Simulation Approach
     *
     * TC: O(N x log(N) + N) ~ O(N x log(N))
     * SC: O(1)
     */
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums); // TC: O(N x log(N))
        int count = 0;
        int start = -1;
        int allowed = -1;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (nums[i] > allowed) {
                start = nums[i];
                allowed = start + k;
                count++;
            }
        }
        return count;
    }
}
