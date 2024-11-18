class Solution {
    /**
     * TC: O(3N) ~ O(N)
     * SC: O(N)
     */
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        if (k == 0) {
            // all elements of new array will be zero
            return new int[n];
        }
        // creating the prefix sum array (replicating twice as array is circular)
        int[] prefixSum = new int[2 * n]; // SC: O(2 x N)
        prefixSum[0] = code[0];
        for (int i  = 1; i < 2 * n; i++) { // TC: O(2 x N)
            prefixSum[i] = prefixSum[i - 1] + code[i % n];
        }

        int[] decryptedCode = new int[n];
        calculateCode(prefixSum, decryptedCode, n, k); // TC: O(N)
        return decryptedCode;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     */
    private void calculateCode(int[] prefixSum, int[] decryptedCode, int n, int k) {
        if (k > 0) {
            for (int i = 0; i < n; i++) {
                decryptedCode[i] = prefixSum[i + k] - prefixSum[i];
            }
        } else {
            k = -1 * k;
            for (int i = n; i < 2 * n; i++) {
                decryptedCode[i - n] = prefixSum[i - 1] - prefixSum[i - k - 1];
            }
        }
    }
}
