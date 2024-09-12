class Solution {
    /**
     * TC: O(K) + O(K' x N) ~ O(N) as 1 <= K <= 26 and 1 <= K' <= 10
     * SC: O(1)
     */
    public int countConsistentStrings(String allowed, String[] words) {
        int masking = 0;
        // TC: O(K)
        for (char ch : allowed.toCharArray()) {
            masking = masking | 1 << (ch - 'a');
        }
        int count = 0;
        // TC: O(N)
        for (String s : words) {
            boolean isMatch = true;
            // TC: O(K')
            for (char ch : s.toCharArray()) {
                int conver = (masking >> (ch - 'a'));
                if ((conver & 1) == 0) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                count++;
            }
        }
        return count;
    }
}
