class Solution {
    /**
     * Approach II : Using Merge Sort Approach
     *
     * TC: O(N x log(N))
     * SC: O(N) + O(log(N))
     *
     * Accepted (21 / 21 testcases passed)
     */
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums, n, 0, n - 1); // TC: O(N x log(N)), SC: O(N) + O(log(N))
        return nums;
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(N x log(N)) + O(N x log(N)) + O(N) ~ O(N x log(N))
     * SC: O(N) + O(log(N))
     */
    private void mergeSort(int[] nums, int n, int left, int right) {
        // Base Case
        if (left == right) {
            // length of nums within range [left, right] is 1 so it is sorted already
            return;
        }
        // Recursion Calls
        int mid = left + (right - left) / 2;
        mergeSort(nums, n, left, mid); // TC: O(N x log(N))
        mergeSort(nums, n, mid + 1, right); // TC: O(N x log(N))
        // Merge Two Sorted Arrays
        mergeSortedArrays(nums, n, left, mid, right); // TC: O(N), SC: O(N)
    }

    /**
     * Using Two Pointers Approach
     *
     * TC: O(R - L + 1) ~ O(N)
     * SC: O(R - L + 1) ~ O(N)
     */
    private void mergeSortedArrays(int[] nums, int n, int left, int mid, int right) {
        int[] merged = new int[right - left + 1]; // SC: O(R - L + 1)
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) { // TC: O(R - L + 1)
            if (nums[i] <= nums[j]) {
                merged[k] = nums[i];
                i++;
            } else {
                merged[k] = nums[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            merged[k] = nums[i];
            i++;
            k++;
        }
        while (j <= right) {
            merged[k] = nums[j];
            k++;
            j++;
        }
        for (i = left; i <= right; i++) {
            nums[i] = merged[i - left];
        }
    }

    /**
     * Approach I : Using Bubble Sort Approach
     *
     * TC: O(N x N)
     * SC: O(1)
     *
     * Time Limit Exceeded (11 / 21 testcases passed)
     */
    public int[] sortArrayUsingBubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) { // TC: O(N)
            for (int j = 1; j < n; j++) { // TC: O(N)
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        return nums;
    }
}
