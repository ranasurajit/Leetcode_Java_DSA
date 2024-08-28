class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;
        int subIslands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    int[] flag = {1};
                    isSubIslandsDFS(grid1, grid2, i, j, flag);
                    subIslands += flag[0];
                }
            }
        }
        return subIslands;
    }

    private void isSubIslandsDFS(int[][] grid1, int[][] grid2, int i, int j, int[] flag) {
        if (i < 0 || i >= grid1.length || j < 0 || j >= grid1[0].length || grid2[i][j] == 0) {
            return;
        }
        if (grid1[i][j] == 0) {
            flag[0] = 0;
        }
        grid2[i][j] = 0; // marking visited
        isSubIslandsDFS(grid1, grid2, i - 1, j, flag); // top
        isSubIslandsDFS(grid1, grid2, i + 1, j, flag); // bottom
        isSubIslandsDFS(grid1, grid2, i, j - 1, flag); // left
        isSubIslandsDFS(grid1, grid2, i, j + 1, flag); // right
    }
}
