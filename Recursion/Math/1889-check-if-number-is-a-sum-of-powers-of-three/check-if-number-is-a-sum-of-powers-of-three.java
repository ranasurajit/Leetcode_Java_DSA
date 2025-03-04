class Solution {
    /**
     * Approach I : Using Math + Recursion Approach
     * 
     * TC: O(2 x K + 2 ^ K) ~ O(2 ^ K)
     * SC: O(2 x K) ~ O(K)
     */
    public boolean checkPowersOfThree(int n) {
        int k = 0;
        while ((int) Math.pow(3, k) <= n) { // TC: O(K)
            k++;
        }
        int[] pow = new int[k]; // SC: O(K)
        for (int i = 0; i < k; i++) { // TC: O(K)
            pow[i] = (int) Math.pow(3, i);
        }
        int[] sum = { 0 };
        return hasSumSubSequence(0, pow, sum, n);
    }

    /**
     * TC: O(2 ^ K)
     * SC: O(K)
     * where K is such that log(N) Base 3
     */
    private boolean hasSumSubSequence(int index, int[] pow, int[] sum, int n) {
        if (index == pow.length) {
            return sum[0] == n;
        }
        // include
        sum[0] += pow[index];
        boolean include = hasSumSubSequence(index + 1, pow, sum, n);
        // exclude
        sum[0] -= pow[index];
        boolean exclude = hasSumSubSequence(index + 1, pow, sum, n);
        return include || exclude;
    }
}
