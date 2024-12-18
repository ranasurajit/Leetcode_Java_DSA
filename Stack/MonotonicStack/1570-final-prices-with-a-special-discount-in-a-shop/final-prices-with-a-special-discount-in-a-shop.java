class Solution {
    /**
     * Optimal Approach (Using Monotonic Stack)
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] fPrices = prices.clone();          // TC: O(N)
        // we are storing the indices in the Monotonic stack
        Stack<Integer> st = new Stack<Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) {            // TC: O(N)
            while (!st.isEmpty() && prices[i] <= prices[st.peek()]) {
                fPrices[st.pop()] -= prices[i];
            }
            st.push(i);
        }
        return fPrices;
    }

    /**
     * Brute-Force Approach
     *
     * TC: O(N x N + N) ~ O(N ^ 2)
     * SC: O(1)
     */
    public int[] finalPricesBruteForce(int[] prices) {
        int n = prices.length;
        int[] fPrices = new int[n];
        for (int i = 0; i < n; i++) {         // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                if (prices[j] <= prices[i]) {
                    fPrices[i] = prices[j];
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {         // TC: O(N)
            fPrices[i] = prices[i] - fPrices[i];
        }
        return fPrices;
    }
}
