class Solution {
    /**
     * Approach II : Using Two Pointers Approach
     * 
     * TC: O(N)
     * SC: O(1)
     *
     * Accepted (65 / 65 testcases passed)
     */
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            int currentArea = Math.min(leftHeight, rightHeight) * (right - left);
            maxArea = Math.max(maxArea, currentArea);
            if (leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    /**
     * Approach I : Using Brute-Force Approach
     * 
     * TC: O(N ^ 2)
     * SC: O(1)
     *
     * Time Limit Exceeded (59 / 65 testcases passed)
     */
    public int maxAreaBruteForce(int[] height) {
        int n = height.length;
        int maxArea = 0;
        for (int i = 0; i < n - 1; i++) { // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                // area = (diff of indices for length * min height of two lines)
                int currentArea = (j - i) * Math.min(height[j], height[i]);
                maxArea = Math.max(maxArea, currentArea);
            }
        }
        return maxArea;
    }
}
