class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] sorted = new int[n];
        int left = 0;
        int right = n - 1;
        int index = n - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) >= Math.abs(nums[right])) {
                sorted[index--] = nums[left] * nums[left];
                left++;
            } else {
                sorted[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return sorted;
    }
}
