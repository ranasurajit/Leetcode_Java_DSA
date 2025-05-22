class Solution {
    /**
     * Approach II : Using Binary Search Approach 
     *
     * TC: O(log(N))
     * SC: O(1)
     */
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) { // TC: O(log(N))
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1); // (mid + 1) is the number expected in the mid index
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low + k;
    }

    /**
     * Approach I : Using Shifting Approach 
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int findKthPositiveShiftingApproach(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (arr[i] <= k) {
                k++;
            } else {
                break;
            }
        }
        return k;
    }
}
