class Solution {
    /**
     * TC: O(N + Q)
     * SC: O(N)
     */
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int[] parity = new int[n];               // SC: O(N)
        parity[0] = 0;
        for (int i = 1; i < n; i++) {            // TC: O(N)
            parity[i] = 
                nums[i] % 2 == nums[i - 1] % 2 ? 1 + parity[i - 1] : parity[i - 1];
        }
        boolean[] result = new boolean[q];
        for (int i = 0; i < q; i++) {            // TC: O(Q)
            int[] query = queries[i];
            result[i] = (parity[query[1]] - parity[query[0]]) == 0;
        }
        return result;
    }
}
