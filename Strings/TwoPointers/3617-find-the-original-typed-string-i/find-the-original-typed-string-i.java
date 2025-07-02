class Solution {
    /**
     * Approach II : Using String Simulation Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int possibleStringCount(String word) {
        int n = word.length();
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            }
        }
        return count + 1;
    }

    /**
     * Approach I : Using String + Two Pointers Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int possibleStringCountTwoPointers(String word) {
        int n = word.length();
        int freq = 0;
        int count = 0;
        int i = 0;
        int j = 1;
        while (j < n) { // TC: O(N)
            while (j < n && word.charAt(j) == word.charAt(i)) {
                j++;
            }
            freq = j - i; // calculated when charAt(j) != charAt(i) so (j - i) gives the repeatition count
            if (freq > 1) {
                count += (freq - 1);
            }
            i = j;
            j++;
        }
        return count + 1;
    }
}
