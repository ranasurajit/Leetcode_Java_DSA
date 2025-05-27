class Solution {
    /**
     * Approach : Using Simulation Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;
        for (int i = 1; i <= n; i++) { // TC: O(N)
            if ((i % m) == 0) {
                num2 += i;
            } else {
                num1 += i;
            }
        }
        return num1 - num2;
    }
}
