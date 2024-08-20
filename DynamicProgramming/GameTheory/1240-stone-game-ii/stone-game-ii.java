class Solution {

    int n;
    int[][][] dp = new int[2][101][101];

    public int stoneGameII(int[] piles) {
        n = piles.length;
        int M = 1;
        int person = 1; // 1 is for Alice and 0 is for Bob
        for (int[][] dp2d : dp) {
            for (int[] dp1d : dp2d) {
                Arrays.fill(dp1d, -1);
            }
        }
        return solve(piles, 1, 0, M);
    }

    private int solve(int[] piles, int person, int i, int M) {
        if (i >= n) {
            return 0;
        }
        if (dp[person][i][M] != -1) {
            return dp[person][i][M];
        }
        int result = person == 1 ? -1 : Integer.MAX_VALUE;
        int stones = 0;
        // Using Game contribution theory - maximize the result for one you're interested else minimize 
        for (int x = 1; x <= Math.min(2 * M, n - i); x++) {
            stones += piles[i + x - 1];
            if (person == 1) { // Alice
                result = Math.max(result, stones + solve(piles, 0, i + x, Math.max(M, x)));
            } else { // Bob
                result = Math.min(result, solve(piles, 1, i + x, Math.max(M, x)));
            }
        }
        dp[person][i][M] = result;
        return dp[person][i][M];
    }
}
