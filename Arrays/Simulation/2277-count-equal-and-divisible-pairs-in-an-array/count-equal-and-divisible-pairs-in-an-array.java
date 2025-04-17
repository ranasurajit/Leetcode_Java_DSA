class Solution {
    /**
     * Approach : Brute-Force (Simulation) Approach
     *
     * TC: O(N ^ 2)
     * SC: O(1)
     */
    public int countPairs(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) { // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
