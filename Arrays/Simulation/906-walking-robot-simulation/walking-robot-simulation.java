class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int n = commands.length;
        int m = obstacles.length;
        HashSet<String> hs = new HashSet<String>();
        for (int i = 0; i < m; i++) {
            hs.add(obstacles[i][0] + "_" + obstacles[i][1]);
        }
        // starting at x, y -> 0, 0
        int x = 0;
        int y = 0;
        int maxDist = 0;
        int[] dir = new int[] { 0, 1 }; // pointing north initially
        for (int i = 0; i < n; i++) {
            if (commands[i] == -2) {
                dir = new int[] { -dir[1], dir[0] }; // Turn left 90 degrees.
            } else if (commands[i] == -1) {
                dir = new int[] { dir[1], -dir[0] }; // Turn right 90 degrees.
            } else {
                for (int j = 0; j < commands[i]; j++) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (hs.contains(newX + "_" + newY)) {
                        break;
                    }
                    x = newX;
                    y = newY;
                }
            }
            maxDist = Math.max(maxDist, x * x + y * y);
        }
        return maxDist;
    }
}
