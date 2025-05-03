class Solution {
    /**
     * Approach : Using Greedy Approach
     *
     * TC: O(3 x N) ~ O(N)
     * SC: O(1)
     */
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int[] freqTop = new int[7];    // SC: O(1)
        int[] freqBottom = new int[7]; // SC: O(1)
        for (int i = 0; i < n; i++) {  // TC: O(N)
            freqTop[tops[i]]++;
            freqBottom[bottoms[i]]++;
        }
        int maxFreq = 0;
        int maxDigit = 0;
        for (int i = 1; i < 7; i++) { // TC: O(1)
            if (freqTop[i] + freqBottom[i] > maxFreq) {
                maxFreq = freqTop[i] + freqBottom[i];
                maxDigit = i;
            }
        }
        int count = 0;
        if (freqTop[maxDigit] > freqBottom[maxDigit]) {
            // swap from bottoms to tops
            for (int i = 0; i < n; i++) { // TC: O(N)
                if (bottoms[i] == maxDigit && tops[i] != maxDigit) {
                    int temp = tops[i];
                    tops[i] = bottoms[i];
                    bottoms[i] = temp;
                    count++;
                }
            }
            // validate if all digits are same in tops
            for (int i = 0; i < n; i++) { // TC: O(N)
                if (tops[i] != maxDigit) {
                    return -1;
                }
            }
        } else {
            // swap from tops to bottoms
            for (int i = 0; i < n; i++) { // TC: O(N)
                if (tops[i] == maxDigit && bottoms[i] != maxDigit) {
                    int temp = tops[i];
                    tops[i] = bottoms[i];
                    bottoms[i] = temp;
                    count++;
                }
            }
            // validate if all digits are same in bottoms
            for (int i = 0; i < n; i++) { // TC: O(N)
                if (bottoms[i] != maxDigit) {
                    return -1;
                }
            }
        }
        return count;
    }
}
