class Solution {
    /**
     * Optimal Approach
     * Using XOR property if { a, b, c } is derived and original is { x, y, z }
     * then  { a, b, c } = { x ^ y, y ^ z, z ^ x }
     * then a ^ b ^ c = x ^ y ^ y ^ z ^ z ^ y
     * so for valid (x, y, z), a ^ b ^ c = 0
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        /**
         * if we xor all the derived elements to be valid it 
         * should return xor(derived) = 0
         */
        int xor = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            xor = (xor ^ derived[i]);
        }
        return xor == 0;
    }

    /**
     * Use XOR property of 
     * derived[i] = original[i] ^ original[i + 1] = 
     * original[i + 1] = derived[i] ^ original[i]
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public boolean doesValidArrayExistBruteForce(int[] derived) {
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
