class Solution {
    /**
     * Approach : Using Greedy + Hashing Approach
     *
     * TC: O(N) + O(N) + O(K x (N / K)) + O(N x log(N)) + O(N) ~ O(N x log(N))
     * SC: O(K) ~ O(N)
     */
    public long minCost(int[] basket1, int[] basket2) {
        int n = basket1.length;
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>(); // SC: O(K)
        int minCostVal = Integer.MAX_VALUE;
        // processing basket1
        for (int i = 0; i < n; i++) { // TC: O(N)
            freqMap.put(basket1[i], freqMap.getOrDefault(basket1[i], 0) + 1);
            minCostVal = Math.min(minCostVal, basket1[i]);
        }
        // processing basket2
        for (int i = 0; i < n; i++) { // TC: O(N)
            // negating the frequency to cancel basket1's duplicate keys that do not require a swap
            freqMap.put(basket2[i], freqMap.getOrDefault(basket2[i], 0) - 1);
            minCostVal = Math.min(minCostVal, basket2[i]);
        }
        List<Integer> unmatchedList = new ArrayList<Integer>();
        for (Integer key : freqMap.keySet()) { // TC: O(K)
            int value = freqMap.get(key);
            if (value % 2 != 0) {
                // values are in odd frequencies so re-arrangment is not possible
                return -1L;
            }
            for (int i = 0; i < Math.abs(value); i++) { // TC: O(N / K), where K << N / 2
                unmatchedList.add(key);
            }
        }
        Collections.sort(unmatchedList); // TC: O(N x log(N))
        long minSwapCost = 0;
        for (int i = 0; i < unmatchedList.size() / 2; i++) { // TC: O(N)
            // add the swap cost between direct swap or indirect swap (to minimize swap cost)
            /**
             * indirect swap is like: swap (9, 10, 2) so, instead 
             * of having swap(9, 10) with cost = Min(9, 10) = 9, we can
             * swap (9, 2) and (10, 2) with cost = Min(9, 2) + Min(10, 2) = 4
             * so 2 is used twice
             */
            minSwapCost += Math.min(unmatchedList.get(i), 2 * minCostVal);
        }
        return minSwapCost / 2;
    }
}
