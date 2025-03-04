class Solution {
    /**
     * Approach II : Using Math + Memoization Approach
     * 
     * TC: O(2 x K + K x N) ~ O(K x N)
     * SC: O(K x N + K) ~ O(K x N)
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
        HashMap<String, Boolean> memo = new HashMap<String, Boolean>(); // SC: O(K x N)
        return hasSumSubSequenceMemoization(k, pow, n, memo);
    }

    /**
     * TC: O(2 ^ K)
     * SC: O(K)
     * where K is such that log(N) Base 3
     */
    private boolean hasSumSubSequenceMemoization(int k, int[] pow, int sum,             
        HashMap<String, Boolean> memo) {
        // Base Case
        if (sum < 0) { // pruning un-necessary calls
            return false;
        }
        if (k == 0) {
            return sum == 0;
        }
        String key = k + "-" + sum;
        // Memoization Check
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // Recursion Calls
        // include
        boolean include = 
            hasSumSubSequenceMemoization(k - 1, pow, sum - pow[k - 1], memo);
        // exclude
        boolean exclude = hasSumSubSequenceMemoization(k - 1, pow, sum, memo);
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
