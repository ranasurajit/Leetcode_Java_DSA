class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        int minimum = prices[0];
        for (int i = 1; i < n; i++) { // TC: O(N)
            int currentProfit = prices[i] - minimum;
            max = Math.max(max, currentProfit);
            // tracking minimum till previous of index i
            minimum = Math.min(minimum, prices[i]);
        }
        return max;
    }
}
