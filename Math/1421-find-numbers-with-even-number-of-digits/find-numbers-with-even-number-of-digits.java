class Solution {
    /**
     * Approach : Using Math (Logarithm) Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int findNumbers(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int digits = 1 + (int) Math.log10(nums[i]);
            if ((digits & 1) == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Approach : Brute-Force Approach
     *
     * TC: O(K x N)
     * SC: O(1)
     */
    public int findNumbersBruteForce(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (String.valueOf(nums[i]).length() % 2 == 0) { // TC: O(K)
                count++;
            }
        }
        return count;
    }
}
