class Solution {
    /**
     * TC: O(N/2) ~ O(N)
     * SC: O(1)
     */
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        // pre-process max from right
        int[] maxRight = new int[n];
        maxRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], nums[i]);
        }
        int maxDiff = 0; // maxDiff will capture the width of ramp (j - i)

        // Using two pointers
        int p = 0;              // pointer for nums
        int q = 0;          // pointer for maxRight
        while (q < n) {
            while (p < q && nums[p] > maxRight[q]) {
                p++;
            }
            maxDiff = Math.max(maxDiff, q - p);
            q++;
        }
        return maxDiff;
    }
}
