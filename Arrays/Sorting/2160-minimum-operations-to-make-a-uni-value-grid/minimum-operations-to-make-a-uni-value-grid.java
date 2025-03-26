class Solution {
    /**
     * Approach : Using Sorting Approach
     *
     * TC: O((2 + (M x N)) x Log(M x N)) ~ O((M x N) x log(M x N))
     * SC: O(M x N)
     */
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] nums = new int[m * n]; // SC: O(M x N)
        int index = 0;
        for (int i = 0; i < m; i++) { // TC: O(M)
            for (int j = 0; j < n; j++) { // TC: O(N)
                nums[index++] = grid[i][j];
            }
        }
        Arrays.sort(nums); // TC: O((M x N) x Log(M x N))
        int i = 0;
        int j = nums.length - 1;
        int mid = i + (j - i) / 2;
        int operations = 0;
        while (i < j) { // TC: O(M x N)
            while (nums[i] < nums[mid]) {
                nums[i] = nums[i] + x;
                operations++;
            }
            if (nums[i] != nums[mid]) {
                return -1;
            }
            i++;
            while (nums[j] > nums[mid]) {
                nums[j] = nums[j] - x;
                operations++;
            }
            if (nums[j] != nums[mid]) {
                return -1;
            }
            j--;
        }
        return operations;
    }
}
