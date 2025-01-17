class Solution {
    /**
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int[] original = new int[n];      // SC: O(N)
        // choice 1 - choose original[0] = 0
        original[0] = 0;
        for (int i = 0; i < n - 1; i++) { // TC: O(N)
            original[i + 1] = (original[i] ^ derived[i]);
        }
        if ((original[0] ^ original[n - 1]) == derived[n - 1]) {
            return true;
        }
        // choice 2 - choose original[0] = 1
        original[0] = 1;
        for (int i = 0; i < n - 1; i++) { // TC: O(N)
            original[i + 1] = (original[i] ^ derived[i]);
        }
        if ((original[0] ^ original[n - 1]) == derived[n - 1]) {
            return true;
        }
        return false;
    }
}
