class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        // offsets - East 0 -> (0, 1), South 1 -> (1, 0), West 2 -> (0, -1), North 3 -> (-1, 0)
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int current = 0; // starts from East
        // steps to take for every direction
        int steps = 0;
        int size = rows * cols;
        int[][] path = new int[size][2];
        // Setting the starting point
        path[0] = new int[] { rStart, cStart };
        int count = 1;
        while (count < size) {
            // East or West step count increases by 1
            if (current == 0 || current == 2) {
                steps++;
            }
            for (int i = 0; i < steps; i++) {
                rStart += directions[current][0];
                cStart += directions[current][1];
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    // if it is inside the boundary
                    path[count++] = new int[]{ rStart, cStart };
                }
            }
            current = (current + 1) % 4;
        }
        return path;
    }
}
