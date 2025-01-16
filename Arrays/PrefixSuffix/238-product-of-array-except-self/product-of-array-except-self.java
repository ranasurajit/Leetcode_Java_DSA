class Solution {
    /**
     * Using Array Pre-processing technique
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // calculating suffixProduct from right to left
        int[] suffix = new int[n]; // SC: O(N)
        suffix[n - 1] = nums[n - 1] * 1;
        for (int i = n - 2; i >= 0; i--) { // TC: O(N)
            suffix[i] = suffix[i + 1] * nums[i];
        }
        /**
         * now we will not create the prefixProduct to save
         * space complexity we will calculate on the fly
         * iterating from left to right
         */
        int prefix = 1;
        for (int i = 0; i < n ; i++) { // TC: O(N)
            if (i < n - 1) {
                res[i] = prefix * suffix[i + 1];
            } else {
                res[i] = prefix * 1;
            }
            // preparing for next iteration
            prefix = prefix * nums[i];
        }
        return res;
    }
}
