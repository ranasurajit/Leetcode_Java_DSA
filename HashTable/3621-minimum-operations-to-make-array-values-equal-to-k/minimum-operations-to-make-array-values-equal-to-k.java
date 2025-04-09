class Solution {
    /**
     * Approach: Using Hashing Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int[] map = new int[101]; // SC: O(101) ~ O(1)
        int minValue = 101;
        for (int i = 0; i < n; i++) { // TC: O(N)
            map[nums[i]]++;
            minValue = Math.min(minValue, nums[i]);
        }
        if (minValue < k) {
            return -1;
        }
        int operations = 0;
        int count = 0;
        int countKs = 0;
        for (int i = map.length - 1; i >= 0; i--) { // TC: O(100) ~ O(1)
            if (map[i] > 0) {
                count++;
                if (i == k) {
                    countKs++;
                }
            }
        }
        return count - countKs;
    }
}
