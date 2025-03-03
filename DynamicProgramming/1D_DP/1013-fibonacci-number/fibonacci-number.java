class Solution {
    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    public int fib(int n) {
        return solveRecursion(n);
    }

    private int solveRecursion(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return solveRecursion(n - 1) + solveRecursion(n - 2);
    }
}
