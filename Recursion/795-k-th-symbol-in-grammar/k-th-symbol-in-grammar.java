class Solution {
    /**
     * Approach : Using Recursion Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public int kthGrammar(int n, int k) {
        return solveRecursion(n, k);
    }

    /**
     * TC: O(N)
     * SC: O(N)
     */
    private int solveRecursion(int n, int k) {
        // Base Case
        if (n == 1 && k == 1) {
            return 0;
        }
        // Hypothesis + Induction
        int size = (int) Math.pow(2, (n - 1));
        int mid = size / 2;
        if (k <= mid) {
            return solveRecursion(n - 1, k);
        } else {
            return solveRecursion(n - 1, k - mid) == 0 ? 1 : 0;
        }
    }
}
