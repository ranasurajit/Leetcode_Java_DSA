class Solution {
    /**
     * Approach : Using BFS Approach
     *
     * TC: O(N x N)
     * SC: O(2 x N x N) ~ O(N x N)
     */
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[][] visited = new boolean[n][n]; // SC: O(N x N)
        Queue<Integer> queue = new LinkedList<Integer>(); // SC: O(N x N)
        queue.offer(1);
        visited[n - 1][0] = true;
        int steps = 0;
        while (!queue.isEmpty()) { // TC: O(N x N)
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int u = queue.poll();
                if (u == n * n) {
                    return steps;
                }
                for (int k = 1; k <= 6; k++) {
                    // we can go from (u + 1) to (u + 6) numbers on the board
                    int position = u + k;
                    if (position > n * n) {
                        break;
                    }
                    int[] coordinates = getCoordinates(position, n);
                    int x = coordinates[0];
                    int y = coordinates[1];
                    if (visited[x][y]) {
                        continue;
                    }
                    visited[x][y] = true;
                    if (board[x][y] == -1) {
                        queue.offer(position);
                    } else {
                        visited[x][y] = true;
                        queue.offer(board[x][y]);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    /**
     * Using Matrix Property
     *
     * TC: O(1)
     * SC: O(1)
     */
    private int[] getCoordinates(int position, int n) {
        int xPosTop = (position - 1) / n;
        int x = n - 1 - xPosTop;
        int y = (position - 1) % n;
        if ((n % 2 == 0 && x % 2 == 0) || (n % 2 == 1 && x % 2 == 1)) {
            y = n - 1 - y;
        }
        return new int[] { x, y };
    }
}
