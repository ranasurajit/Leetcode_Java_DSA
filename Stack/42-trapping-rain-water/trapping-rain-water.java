class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] lrMax = new int[n];
        int[] rlMax = new int[n];
        int lMax = Integer.MIN_VALUE;
        int rMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            lMax = Math.max(lMax, height[i]);
            rMax = Math.max(rMax, height[n - i - 1]);
            lrMax[i] = lMax;
            rlMax[n - i - 1] = rMax;
        }
        int trapped = 0;
        for (int i = 0; i < n; i++) {
            trapped += Math.abs(Math.min(lrMax[i], rlMax[i]) - height[i]);
        }
        return trapped;
    }
}