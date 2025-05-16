class Solution {
    /**
     * Approach : Using Array Pre-processing Approach
     *
     * TC: O(3 x N) ~ O(N)
     * SC: O(2 x N)
     */
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];  // SC: O(N)
        int[] rightMax = new int[n]; // SC: O(N)
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) { // TC: O(N)
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) { // TC: O(N)
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int trapped = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            trapped += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return trapped;
    }
}
