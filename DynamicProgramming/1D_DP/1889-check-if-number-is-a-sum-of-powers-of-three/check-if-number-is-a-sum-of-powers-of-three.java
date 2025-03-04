class Solution {
    /**
     * Approach II : Using Math + Memoization Approach
     * 
     * TC: O(3 x K) ~ O(K)
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
        int sum = 0;
        Map<String, Boolean> memo = new HashMap<String, Boolean>(); // SC: O(K)
        return hasSumSubSequenceMemoization(0, pow, sum, n, memo);
    }

    /**
     * TC: O(K)
     * SC: O(K)
     * where K is such that log(N) Base 3
     */
    private boolean hasSumSubSequenceMemoization(int index, int[] pow, 
        int sum, int n, Map<String, Boolean> memo) {
        // base case
        if (sum > n) { // pruning un-necessary calls
            return false;
        }
        if (index == pow.length) {
            return sum == n;
        }
        String key = index + "-" + sum;
        // memoization check
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // include
        boolean include = 
            hasSumSubSequenceMemoization(index + 1, pow, sum + pow[index], n, memo);
        // exclude
        boolean exclude =
            hasSumSubSequenceMemoization(index + 1, pow, sum, n, memo);
        boolean result = include || exclude;
        memo.put(key, result);
        return result;
    }

    /**
     * Approach I : Using Math + Recursion Approach
     * 
     * TC: O(2 x K + 2 ^ K) ~ O(2 ^ K)
     * SC: O(2 x K) ~ O(K)
     */
    public boolean checkPowersOfThreeRecursion(int n) {
        int k = 0;
        while ((int) Math.pow(3, k) <= n) { // TC: O(K)
            k++;
        }
        int[] pow = new int[k]; // SC: O(K)
        for (int i = 0; i < k; i++) { // TC: O(K)
            pow[i] = (int) Math.pow(3, i);
        }
        int sum = 0;
        return hasSumSubSequenceRecursion(0, pow, sum, n);
    }

    /**
     * TC: O(2 ^ K)
     * SC: O(K)
     * where K is such that log(N) Base 3
     */
    private boolean hasSumSubSequenceRecursion(int index, int[] pow, int sum, int n) {
        if (sum > n) { // pruning un-necessary calls
            return false;
        }
        if (index == pow.length) {
            return sum == n;
        }
        // include
        boolean include = 
            hasSumSubSequenceRecursion(index + 1, pow, sum + pow[index], n);
        // exclude
        boolean exclude = hasSumSubSequenceRecursion(index + 1, pow, sum, n);
        return include || exclude;
    }
}
