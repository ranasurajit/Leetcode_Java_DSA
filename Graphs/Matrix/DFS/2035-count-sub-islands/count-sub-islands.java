class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;
        int subIslands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && isSubIslandsDFS(grid1, grid2, i, j)) {
                    subIslands++;
                }
            }
        }
        return subIslands;
    }

    private boolean isSubIslandsDFS(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || i >= grid1.length || j < 0 || j >= grid1[0].length) {
            return true;
        }
        if (grid2[i][j] != 1) {
            return true;
        }
        grid2[i][j] = -1; // marking visited
        boolean isSubIsland = (grid1[i][j] == 1);
        isSubIsland = isSubIsland & isSubIslandsDFS(grid1, grid2, i - 1, j); // top
        isSubIsland = isSubIsland & isSubIslandsDFS(grid1, grid2, i + 1, j); // bottom
        isSubIsland = isSubIsland & isSubIslandsDFS(grid1, grid2, i, j - 1); // left
        isSubIsland = isSubIsland & isSubIslandsDFS(grid1, grid2, i, j + 1); // right
        return isSubIsland;
    }
}
