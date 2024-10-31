class Solution {
    private final long MAX = 10000000000000L;

    /**
     * TC: O(M x log(M)) + O(N x log(N)) + O(2 x M x N) ~ O(M x N)
     * SC: O(M x N)
     */
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot); // sorting robot positions - TC: O(M x log(M))
        // sorting factoru based on positions - TC: O(N x log(N))
        Arrays.sort(factory, (int[] a, int[] b) -> a[0] - b[0]);
        // converting multiple factories limits to single independent factory instances
        List<Integer> factories = new ArrayList<Integer>();
        for (int[] fact : factory) { // TC: O(100 x 100) = O(10000)
            int pos = fact[0];
            int limit = fact[1];
            for (int i = 0; i < limit; i++) {
                factories.add(pos);
            }
        }
        int m = robot.size();
        int n = factories.size();
        long[][] dp = new long[m][n]; // SC: O(M x N)
        for (long[] dp1D: dp) { // TC: O(M x N)
            Arrays.fill(dp1D, -1L);
        }
        // TC: O(M x N), SC: O(H) where H is the height of recursion tree stack
        return solve(robot, m - 1, factories, n - 1, dp);
    }

    private long solve(List<Integer> robot, int robotPos, List<Integer> factories, 
        int factPos, long[][] dp) {
        if (robotPos < 0) {
            return 0;
        }
        if (factPos < 0) {
            return MAX;
        }
        if (dp[robotPos][factPos] != -1L) {
            return dp[robotPos][factPos];
        }
        long take = Math.abs(factories.get(factPos) - robot.get(robotPos)) +
            solve(robot, robotPos - 1, factories, factPos - 1, dp);
        long nottake = solve(robot, robotPos, factories, factPos - 1, dp);
        dp[robotPos][factPos] = Math.min(take, nottake);
        return dp[robotPos][factPos];
    }
}
