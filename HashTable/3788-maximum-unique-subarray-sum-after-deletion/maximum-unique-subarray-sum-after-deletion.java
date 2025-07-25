class Solution {
    /**
     * Approach : Using Hashing Approach
     *
     * TC: O(N) + O(N) ~ O(N)
     * SC: O(N)
     */
    public int maxSum(int[] nums) {
        int n = nums.length;
        /**
         * since we need to delete any number of elements from nums without making it empty, so we
         * can convert duplicate elements to zero and  we can choose to remove negatives by 
         * replacing it with zeros to make the sum maximum
         * There is an edge-case if all the elements are negative then we need to return the maximum
         * value from all negatives
         */
        int maxNeg = Integer.MIN_VALUE;
        int countNeg = 0;
        Set<Integer> hs = new HashSet<Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (nums[i] > 0 && hs.contains(nums[i])) {
                nums[i] = 0;
            }
            if (nums[i] < 0) {
                countNeg++;
                maxNeg = Math.max(maxNeg, nums[i]);
                nums[i] = 0;
            }
            hs.add(nums[i]);
        }
        if (countNeg == n) {
            return maxNeg;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            sum += nums[i];
        }
        return sum;
    }
}
