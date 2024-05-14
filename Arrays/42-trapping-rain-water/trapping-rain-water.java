class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] pre = new int[n];
        int[] post = new int[n];
        int maxL = height[0];
        int maxR = height[n - 1];
        int trapped = 0;

        for (int i = 0; i < n; i++) {
            if (maxL <= height[i]) {
                maxL = height[i];
            }
            if (maxR <= height[n - i - 1]) {
                maxR = height[n - i - 1];
            }
            pre[i] = maxL;
            post[n - i - 1] = maxR;
        }
        for (int i = 0; i < n; i++) {
            trapped += (Math.min(pre[i], post[i]) - height[i]);
        }
        return trapped;
    }
}
