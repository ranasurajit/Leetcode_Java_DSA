class Solution {
    /**
     * Approach : Using Greedy Approach
     *
     * TC: O(N)
     * SC: O(1)
     * 
     */
    public int jump(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = 0;
        int jumps = 0;
        while (high < n - 1) { // TC: O(N)
            int farthest = 0;
            for (int i = low; i <= high; i++) {
                farthest = Math.max(farthest, nums[i] + i);
            }
            low = high + 1;
            high = farthest;
            jumps++;
        }
        return jumps;
    }
}
