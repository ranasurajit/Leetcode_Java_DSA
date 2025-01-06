class Solution {
    /**
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] result = new int[n];
        int cumVal = 0;
        int cumValSum = 0;
        // left to right
        for (int i = 0; i < n; i++) {      // TC: O(N)
            result[i] = cumValSum;
            cumVal += boxes.charAt(i) == '1' ? 1 : 0;
            cumValSum += cumVal;
        }
        cumVal = 0;
        cumValSum = 0;
        // right to left
        for (int i = n - 1; i >= 0; i--) { // TC: O(N)
            result[i] += cumValSum;
            cumVal += boxes.charAt(i) == '1' ? 1 : 0;
            cumValSum += cumVal;
        }
        return result;
    }
}
