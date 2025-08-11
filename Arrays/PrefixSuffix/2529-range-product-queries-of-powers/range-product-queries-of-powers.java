class Solution {
    private static int MOD = (int) 1e9 + 7;

    public int[] productQueries(int n, int[][] queries) {
        int total = n;
        /**
         * n is nothing but the sum of Binary Representation of n
         */
        List<Long> numList = new ArrayList<Long>();
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                numList.add((long) 1 << i);
            }
        }
        int q = queries.length;
        int[] result = new int[q];
        for (int i = 0; i < q; i++) { // TC: O(Q)
            int start = queries[i][0];
            int end = queries[i][1];
            long prod = 1;
            for (int j = start; j <= end; j++) {
                prod = (prod * numList.get(j)) % MOD;
            }
            result[i] = (int) prod;
        }
        return result;
    }
}
