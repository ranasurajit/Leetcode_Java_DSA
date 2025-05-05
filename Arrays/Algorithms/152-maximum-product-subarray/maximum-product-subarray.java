class Solution {
    /**
     * Approach I: Brute-Force Approach
     *
     * TC: O(N ^ 2)
     * SC: O(1)
     */
    public int maxProduct(int[] nums) {
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
