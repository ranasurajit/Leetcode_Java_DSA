class Solution {
    /**
     * Approach I : Brute-Force Approach
     *
     * TC: O(6 x N) ~ O(N)
     * SC: O(1)
     */
    public int minOperations(int[] nums) {
        int n = nums.length;
        int operations = 0;
        for (int i = 0; i < n - 2; i++) { // TC: O(N)
            if (nums[i] == 1) {
                continue;
            }
            int sum = 0;
            for (int j = i; j < i + 3; j++) { // TC: O(3)
                sum += nums[j];
            }
            if (sum < 3) {
                operations++;
                for (int j = i; j < i + 3; j++) { // TC: O(3)
                    nums[j] = nums[j] == 0 ? 1 : 0;
                }
            }
        }
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (nums[i] == 0) {
                return -1;
            }
        }
        return operations;
    }
}
