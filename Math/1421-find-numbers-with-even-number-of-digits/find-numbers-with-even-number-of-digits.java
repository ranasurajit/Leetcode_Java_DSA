class Solution {
    /**
     * Approach III : Using Ranges/Constraints Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int findNumbers(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if ((nums[i] >= 10 && nums[i] <= 99) || (nums[i] >= 1000 && nums[i] <= 9999) ||
                nums[i] == 100000) {
                count++;
            }
        }
        return count;
    }

    /**
     * Approach II : Using Math (Logarithm) Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int findNumbersLogarithmApproach(int[] nums) {
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
     * Approach I : Brute-Force Approach
     *
     * TC: O(K x N)
     * SC: O(1)
     */
    public int findNumbersBruteForceApproach(int[] nums) {
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
