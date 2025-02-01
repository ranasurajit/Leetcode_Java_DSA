class Solution {
    /**
     * Approach II
     *
     * XOR of Odd and Even numbers is 1 for different parity
     * XOR of Odd/Odd or Even/Even numbers is 0 for same parity
     * 
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
            if (((nums[i] ^ nums[i - 1]) & 1) == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Approach I - Sum of Odd and Even numbers is Odd
     *
     * TC: O(N)
     * SC: O(1)
     */
    public boolean isArraySpecialApproachI(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return true;
        }
        for (int i = 1; i < n; i++) { // TC: O(N)
            // sum of different parity (odd and even) will always be odd
            if (((nums[i] + nums[i - 1]) & 1) == 0) {
                return false;
            }
        }
        return true;
    }
}
