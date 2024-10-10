class Solution {
    /**
     * TC: O(2N) ~ O(N)
     * SC: O(N)
     */
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        // pre-process max from right
        int[] maxRight = new int[n]; // SC: O(N)
        maxRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) { // TC: O(N)
            maxRight[i] = Math.max(maxRight[i + 1], nums[i]);
        }
        int maxDiff = 0; // maxDiff will capture the width of ramp (j - i)

        // Using two pointers
        int p = 0;              // pointer for nums
        int q = 0;              // pointer for maxRight
        while (q < n) { // TC: O(N)
            while (p < q && nums[p] > maxRight[q]) {
                p++;
            }
            maxDiff = Math.max(maxDiff, q - p);
            q++;
        }
        return maxDiff;
    }
}
