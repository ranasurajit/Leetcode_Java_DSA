class Solution {
    /**
     * TC: O(N x N + N) ~ O(N ^ 2)
     * SC: O(1)
     */
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] finalPrices = new int[n];
        for (int i = 0; i < n; i++) {         // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                if (prices[j] <= prices[i]) {
                    finalPrices[i] = prices[j];
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {         // TC: O(N)
            finalPrices[i] = prices[i] - finalPrices[i];
        }
        return finalPrices;
    }
}
