class Solution {
    /**
     * Approach : Using Hashing Approach
     *
     * TC: O(N x N x 26) ~ O(N x N)
     * SC: O(26) ~ O(1)
     */
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;
        for (int i = 0; i < n; i++) {           // TC: O(N)
            int[] freq = new int[26];           // SC: O(26)
            for (int j = i; j < n; j++) {       // TC: O(N)
                freq[s.charAt(j) - 'a']++;
                int minFreq = Integer.MAX_VALUE;
                int maxFreq = Integer.MIN_VALUE;
                for (int k = 0; k < 26; k++) {  // TC: O(26)
                    if (freq[k] > 0) {
                        minFreq = Math.min(minFreq, freq[k]);
                        maxFreq = Math.max(maxFreq, freq[k]);
                    }
                }
                sum += maxFreq - minFreq;
            }
        }
        return sum;
    }
}
