class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return true;
        }
        for (int i = 1; i < n; i++) { // TC: O(N)
            // sum of different parity (odd and even) will always be odd
            int sum = nums[i] + nums[i - 1];
            if ((sum & 1) == 0) {
                return false;
            }
        }
        return true;
    }
}
