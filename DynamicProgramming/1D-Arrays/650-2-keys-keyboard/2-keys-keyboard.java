class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        if (n > 1) {
            dp[2] = 2;
        }
        for (int i = 3; i <= n; i++) {
            int factor = i / 2; // greatest factor for i
            while (factor >= 1) {
                if (i % factor == 0) {
                    int stepsTillFactor = dp[factor];
                    int copyOp = 1;
                    int pasteOp = (i / factor) - 1;
                    dp[i] = stepsTillFactor + copyOp + pasteOp;
                    break;
                } else {
                    factor--;
                }
            }
        }
        return dp[n];
    }
}
