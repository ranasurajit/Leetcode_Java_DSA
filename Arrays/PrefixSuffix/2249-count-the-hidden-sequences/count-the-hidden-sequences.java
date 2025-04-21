class Solution {
    /**
     * Approach III : Using Array Pre-Processing (Without Space) + Math Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int n = differences.length;
        int hidden = 0;
        int minValue = 0;
        int maxValue = 0;
        for (int diff : differences) { // TC: O(N)
            hidden += diff;
            minValue = Math.min(minValue, hidden);
            maxValue = Math.max(maxValue, hidden);
            /**
            * possible values for hidden[0] i.e. 
            * start + minValue >= lower and start + maxValue <= upper
            * i.e. lower - minValue <= start <= upper - maxValue
            */
            if ((upper - maxValue) - (lower - minValue) + 1 <= 0) {
                return 0;
            }
        }
        return (upper - maxValue) - (lower - minValue) + 1;
    }

    /**
     * Approach II : Using Array Pre-Processing (Without Space) Approach
     *
     * TC: O(N + R)
     * SC: O(1)
     *
     * where R = Range (upper - lower + 1)
     */
    public int numberOfArraysApproachII(int[] differences, int lower, int upper) {
        int n = differences.length;
        int hidden = 0;
        int minValue = 0;
        int maxValue = 0;
        for (int i = 1; i <= n; i++) { // TC: O(N)
            hidden = differences[i - 1] + hidden;
            minValue = Math.min(minValue, hidden);
            maxValue = Math.max(maxValue, hidden);
        }
        int countSeq = 0;
        for (int i = lower; i <= upper; i++) { // TC: O(upper - lower + 1) ~ O(R)
            if (minValue + i >= lower && maxValue + i <= upper) {
                countSeq++;
            }
        }
        return countSeq;
    }

    /**
     * Approach I : Using Array Pre-Processing Approach
     *
     * TC: O(N + R)
     * SC: O(N)
     *
     * where R = Range (upper - lower + 1)
     */
    public int numberOfArraysApproachI(int[] differences, int lower, int upper) {
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
