class Solution {
    /**
     * Approach: Using Array Pre-Processing Approach
     *
     * TC: O(N + R)
     * SC: O(N)
     *
     * where R = Range (upper - lower + 1)
     */
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int n = differences.length;
        int[] hidden = new int[n + 1]; // SC: O(N + 1)
        hidden[0] = 0; // setting offset as 0 by setting hidden[0] = 0
        int minValue = hidden[0];
        int maxValue = hidden[1];
        for (int i = 1; i <= n; i++) { // TC: O(N)
            hidden[i] = differences[i - 1] + hidden[i - 1];
            minValue = Math.min(minValue, hidden[i]);
            maxValue = Math.max(maxValue, hidden[i]);
        }
        // now storing min and max values in array 'hidden'
        int countSeq = 0;
        for (int i = lower; i <= upper; i++) { // TC: O(upper - lower + 1) ~ O(R)
            if (minValue + i >= lower && maxValue + i <= upper) {
                countSeq++;
            }
        }
        return countSeq;
    }
}
