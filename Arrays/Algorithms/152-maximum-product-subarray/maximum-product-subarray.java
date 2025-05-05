class Solution {
    /**
     * Approach II : Optimal Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (prefix == 0) {
                // reset prefix to 1 to start of with a new subarray
                prefix = 1;
            }
            if (suffix == 0) {
                // reset suffix to 1 to start of with a new subarray
                suffix = 1;
            }
            prefix = prefix * nums[i];
            suffix = suffix * nums[n - i - 1];
            maxProd = Math.max(maxProd, Math.max(prefix, suffix));
        }
        return maxProd;
    }

    /**
     * Approach I : Brute-Force Approach
     *
     * TC: O(N ^ 2)
     * SC: O(1)
     */
    public int maxProductBruteForce(int[] nums) {
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int prod = 1;
            for (int j = i; j < n; j++) { // TC: O(N)
                prod *= nums[j];
                maxProd = Math.max(maxProd, prod);
            }
        }
        return maxProd;
    }
}
