class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public int maximumSwap(int num) {
        char[] ch = Integer.toString(num).toCharArray();
        int n = ch.length;
        char maxElement = ch[n - 1];
        int maxIndex = n - 1;
        int swapIndex1 = -1;
        int swapIndex2 = -1;
        for (int i = n - 2; i >= 0; i--) { // TC: O(N)
            if (ch[i] > maxElement) {
                maxElement = ch[i];
                maxIndex = i;
            } else if (ch[i] < maxElement) {
                swapIndex1 = i;
                swapIndex2 = maxIndex;
            }
        }
        // swap numbers at swapIndex1 with swapIndex2
        if (swapIndex1 != -1) {
            char temp = ch[swapIndex1];
            ch[swapIndex1] = ch[swapIndex2];
            ch[swapIndex2] = temp;
        }
        return Integer.valueOf(new String(ch));
    }
}
