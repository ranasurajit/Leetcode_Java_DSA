class Solution {
    private final int MOD = (int) 1e9 + 7;

    /**
     * Approach : Using Mathematical Approach (Permutations and Combinations)
     *
     * TC: O(2 x log(N)) ~ O(log(N))
     * SC: O(log(N))
     */
    public int countGoodNumbers(long n) {
        long evenIndices = (n + 1) / 2;
        long oddIndices = n / 2;
        /**
         * since digit may contain leading zeros too so,
         * for each even indices we have 5 possibilities
         * for odd indices we have 4 possibilities
         */
        long count = (fastPower(5, evenIndices) * fastPower(4, oddIndices)) % MOD;
        return (int) count;
    }

    /**
     * Using Binary Exponentiation
     *
     * TC: O(log(B))
     * SC: O(log(B))
     */
    private long fastPower(long a, long b) {
        if (b == 0L) {
            return 1;
        }
        long half = fastPower(a, b / 2);
        long answer = (half * half) % MOD;
        if ((b & 1) != 0) {
            // b is odd
            return (answer * a) % MOD;
        }
        return answer;
    }
}
