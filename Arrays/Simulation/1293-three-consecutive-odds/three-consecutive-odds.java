class Solution {
    /**
     * Approach : Using Simulation
     *
     * TC: O(N)
     * SC: O(1)
     */
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return false;
        }
        for (int i = 2; i < n; i++) { // TC: O(N)
            if ((arr[i] & 1) == 1 && (arr[i - 1] & 1) == 1 && (arr[i - 2] & 1) == 1) {
                return true;
            }
        }
        return false;
    }
}
