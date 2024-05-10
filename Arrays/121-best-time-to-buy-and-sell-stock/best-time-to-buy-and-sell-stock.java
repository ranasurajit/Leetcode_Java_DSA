class Solution {
    public int maxProfit(int[] prices) {
        int pmax = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            int profit = prices[i] - min;
            pmax = Math.max(pmax, profit);
        }
        return pmax;
    }
}
