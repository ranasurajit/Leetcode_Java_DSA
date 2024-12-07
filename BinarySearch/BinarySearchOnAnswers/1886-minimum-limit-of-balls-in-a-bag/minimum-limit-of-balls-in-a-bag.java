class Solution {
    /**
     * TC: O(N + N x log(K)) ~ O(N x log(K))
     * SC: O(1)
     * where K is the Max(nums)
     */
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = 0;
        for (int item : nums) { // TC: O(N)
            high = Math.max(high, item);
        }
        int penalty = 0;
        while (low <= high) {  // TC: O(log(K)), where K is the Max(nums)
            int mid = low + (high - low) / 2;
            int numOperations = getOperationCount(nums, mid);  // TC: O(N)
            if (numOperations <= maxOperations) {
                penalty = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return penalty;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     */
    private int getOperationCount(int[] nums, int slice) {
        int totalOperations = 0;
        for (int item : nums) { // TC: O(N)
            int operations = item / slice;
            if (item % slice == 0) {
                operations = operations - 1;
            }
            totalOperations += operations;
        }
        return totalOperations;
    }
}
