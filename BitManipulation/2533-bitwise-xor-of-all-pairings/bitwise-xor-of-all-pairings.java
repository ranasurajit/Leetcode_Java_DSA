class Solution {
    /**
     * TC: O(M + N)
     * SC: O(1)
     */
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // if m and n are both even
        if (m % 2 == 0 && n % 2 == 0) {
            return 0;
        } else if (m % 2 == 0 && n % 2 != 0) {
            /**
             * in case one of the arrays is odd, then result 
             * will be XORs of even length array
             * Rest of all products gets cancelled by XOR operation
             */
            return getXOR(nums1); // TC: O(M)
        } else if (m % 2 != 0 && n % 2 == 0) {
            /**
             * in case one of the arrays is odd, then result 
             * will be XORs of even length array
             * Rest of all products gets cancelled by XOR operation
             */
            return getXOR(nums2); // TC: O(N)
        } else {
            // both arrays are of odd length then result will be individual XORs
            return getXOR(nums1) ^ getXOR(nums2); // TC: O(M + N)
        }
    }

    /**
     * TC: O(N)
     * SC: O(N)
     */
    private int getXOR(int[] nums) {
        int n = nums.length;
        int result = nums[0];
        for (int i = 1; i < n; i++) { // TC: O(N)
            result = result ^ nums[i];
        }
        return result;
    }
}
