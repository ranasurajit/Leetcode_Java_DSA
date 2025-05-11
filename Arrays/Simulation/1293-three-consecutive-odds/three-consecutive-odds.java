class Solution {
    /**
     * Approach II : Using Simulation + Math
     * Intuition: Product of odd numbers is always odd
     *
     * TC: O(N)
     * SC: O(1)
     */
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return false;
        }
        int product = 1;
        for (int i = 0; i < n - 2; i++) { // TC: O(N)
            product = arr[i] * arr[i + 1] * arr[i + 2];
            if ((product & 1) == 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Approach I : Using Simulation
     *
     * TC: O(N)
     * SC: O(1)
     */
    public boolean threeConsecutiveOddsSimulation(int[] arr) {
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
