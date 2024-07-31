class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int[] row : grid) {
            Arrays.sort(row);
        }
        int count = 0;
        int output = 0;
        while (count < cols) {
            int current = Integer.MIN_VALUE;
            for (int i = 0; i < rows; i++) {
                current = Math.max(current, grid[i][cols - 1 - count]);
            }
            output += current;
            count++;
        }
        return output;
    }
}
