class Solution {
    /**
     * TC: O(2N) ~ O(N)
     * SC: O(N)
     */
    public char findKthBit(int n, int k) {
        // it is understood that the length of the binary string would be 2^n - 1
        int length = (int) Math.pow(2, n) - 1;
        return solve(length, k);
    }

    private char solve(int n, int k) {
        if (n == 1) {
            return '0';
        }
        int half = n / 2;
        int mid = half + 1;
        if (mid == k) {
            return '1';
        } else if (k < mid) {
            // fall back to previous binary string
            return solve(half, k);
        } else {
            // find the inverted from previous binary string
            char c = solve(half, n - k + 1);
            return c == '0' ? '1' : '0';
        }
    }
}
