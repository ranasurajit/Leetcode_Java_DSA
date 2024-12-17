class Solution {
    /**
     * TC: O(2 x N) ~ O(N)
     * SC: O(26) ~ O(1)
     */
    public String repeatLimitedString(String s, int repeatLimit) {
        int n = s.length();
        // We need to store frequency of all characters in String 's'
        int[] freq = new int[26]; // SC: O(26)
        for (int i = 0; i < n; i++) { // TC: O(N)
            freq[s.charAt(i) - 'a']++;
        }
        /*
         * we will iterate from last index i.e. 25 to add characters
         * in lexicographic order
         */
        int last = 25;
        StringBuilder sb = new StringBuilder();
        while (last >= 0) { // TC: O(N)
            if (freq[last] == 0) {
                // skipping the characters with frequency = 0
                last--;
                continue;
            }
            int used = Math.min (freq[last], repeatLimit);
            for (int k = 0; k < used; k++) {
                sb.append((char) ('a' + last));
            }
            freq[last] -= used;
            // if frequency is still left, we need to find prev index which has freq > 0
            if (freq[last] > 0) {
                int prevIndex = last - 1;
                while (prevIndex >= 0 && freq[prevIndex] == 0) {
                    prevIndex--;
                }
                if (prevIndex < 0) {
                    /*
                     * in this case all prev indices has no frequency
                     * so we cannot use all characters of String 's'
                     */
                    break;
                }
                sb.append((char) ('a' + prevIndex));
                freq[prevIndex]--;
            }
        }
        return sb.toString();
    }
}
