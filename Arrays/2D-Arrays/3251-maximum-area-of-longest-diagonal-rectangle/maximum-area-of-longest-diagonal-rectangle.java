class Solution {
    /**
     * Approach : Using Simulation + Math Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;
        int maxDiagonal = 0;
        int maxArea = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int length = dimensions[i][0];
            int width = dimensions[i][1];
            int diagonal = length * length + width * width;
            if (maxDiagonal < diagonal) {
                maxDiagonal = diagonal;
                maxArea = length * width;
            } else if (maxDiagonal == diagonal) {
                maxArea = Math.max(maxArea, length * width);
            }
        }
        return maxArea;
    }
}
