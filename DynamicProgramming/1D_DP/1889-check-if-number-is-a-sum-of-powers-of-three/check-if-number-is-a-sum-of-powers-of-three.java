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
        return hasSumSubSequenceRecursion(k, pow, n);
    }

    /**
     * TC: O(2 ^ K)
     * SC: O(K)
     * where K is such that log(N) Base 3
     */
    private boolean hasSumSubSequenceRecursion(int k, int[] pow, int sum) {
        // Base Case
        if (sum < 0) { // pruning un-necessary calls
            return false;
        }
        if (k == 0) {
            return sum == 0;
        }
        // Recursion Calls
        // include
        boolean include = 
            hasSumSubSequenceRecursion(k - 1, pow, sum - pow[k - 1]);
        // exclude
        boolean exclude = hasSumSubSequenceRecursion(k - 1, pow, sum);
        return include || exclude;
    }
}
