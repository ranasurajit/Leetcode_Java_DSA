class Solution {
    /**
     * Approach II: Using Binary Search Approach 
     * 
     *
     * TC: O(2 x log(N)) ~ O(log(N))
     * SC: O(1)
     */
    public int maximumCount(int[] nums) {
        int n = nums.length;
        // Lower bound till x = 0, will return number of elements < 0
        int negIndex = lowerBound(nums, n, 0); // TC: O(log(N))
        // Upper bound till x = 0, will return the index at which elements > 0 begins
        int posIndex = upperBound(nums, n, 0); // TC: O(log(N))
        return Math.max(negIndex, n - posIndex);
    }

    /**
     * Using LowerBound Approach 
     * nums[i] >= x
     *
     * TC: O(log(N))
     * SC: O(1)
     */
    private int lowerBound(int[] nums, int n, int x) {
        int low = 0;
        int high = n - 1;
        while (low <= high) { // TC: O(log(N))
            int mid = low + (high - low) / 2;
            if (nums[mid] >= x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * Using UpperBound Approach 
     * nums[i] > x
     *
     * TC: O(log(N))
     * SC: O(1)
     */
    private int upperBound(int[] nums, int n, int x) {
        int low = 0;
        int high = n - 1;
        while (low <= high) { // TC: O(log(N))
            int mid = low + (high - low) / 2;
            if (nums[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * Approach I : Using Normal Simulation
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int maximumCountApproachI(int[] nums) {
        int n = nums.length;
        int numNeg = 0;
        int numPos = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (nums[i] < 0) {
                numNeg++;
            } else if (nums[i] > 0) {
                numPos++;
            }
        }
        return Math.max(numNeg, numPos);
    }
}
