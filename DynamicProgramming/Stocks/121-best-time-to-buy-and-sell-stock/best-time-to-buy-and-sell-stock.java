class Solution {
    /**
     * Approach : Using Simulation Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxP = Integer.MIN_VALUE;
        int minValue = prices[0];
        for (int i = 1; i < n; i++) { // TC: O(N)
            minValue = Math.min(minValue, prices[i - 1]);
            maxP = Math.max(maxP, prices[i] - minValue);
        }
        return Math.max(0, maxP);
    }
}
