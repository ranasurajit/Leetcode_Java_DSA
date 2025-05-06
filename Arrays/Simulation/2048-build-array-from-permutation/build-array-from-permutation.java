class Solution {
    /**
     * Approach : Using Simulation
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) { // TC: O(N)
            result[i] = nums[nums[i]];
        }
        return result;
    }
}
