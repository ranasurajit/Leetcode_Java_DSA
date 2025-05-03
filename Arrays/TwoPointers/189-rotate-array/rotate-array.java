class Solution {
    /**
     * Approach : Using Reverse Array Approach
     *
     * TC: O(3 x (N / 2)) ~ O(N)
     * SC: O(1)
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) {
            return;
        }
        k = k % n;
        reverseArray(nums, 0, n - 1); // TC: O(N / 2)
        reverseArray(nums, 0, k - 1); // TC: O(N / 2)
        reverseArray(nums, k, n - 1); // TC: O(N / 2)
    }

    /**
     * Reverse Array Approach
     *
     * TC: O(N / 2)
     * SC: O(1)
     */
    private void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            // swap values in 'start' and 'end' indices
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}
