class Solution {
    public int maxProfit(int[] prices) {
        int pmax = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            }
            int profit = prices[i] - min;
            if (pmax < profit) {
                pmax = profit;
            }
        }
        return pmax;
    }
}
