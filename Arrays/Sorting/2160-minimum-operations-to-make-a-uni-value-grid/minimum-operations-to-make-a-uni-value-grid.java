class Solution {
    /**
     * Approach II : Using Sorting and Two Pointers Approach
     *
     * TC: O((2 + (M x N)) x Log(M x N)) ~ O((M x N) x log(M x N))
     * SC: O(M x N)
     *
     * Runtime - 34 ms, Beats 90.45%
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
        int target = nums[i + (j - i) / 2];
        int operations = 0;
        while (i < j) { // TC: O(M x N)
            if ((target - nums[i]) % x != 0) {
                return -1;   
            }
            operations += (target - nums[i]) / x;
            i++;
            if ((nums[j] - target) % x != 0) {
                return -1;   
            }
            operations += (nums[j] - target) / x;
            j--;
        }
        return operations;
    }

    /**
     * Approach I : Using Sorting Approach
     *
     * TC: O((2 + (M x N)) x Log(M x N)) ~ O((M x N) x log(M x N))
     * SC: O(M x N)
     *
     * Runtime - 36 ms, Beats 86.43%
     */
    public int minOperationsApproachI(int[][] grid, int x) {
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
        int target = nums[nums.length / 2];
        int operations = 0;
        for (int i = 0; i < m * n; i++) { // TC: O(M x N)
            if ((target - nums[i]) % x != 0) {
                return -1;
            }
            operations += Math.abs(target - nums[i]) / x;
        }
        return operations;
    }
}
