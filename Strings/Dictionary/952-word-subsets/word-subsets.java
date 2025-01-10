class Solution {
    /**
     * TC: O(M x L + N x L) ~ O(M + N)
     * SC: O(26) ~ O(1)
     * where 1 <= L <= 10
     */
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> uni = new ArrayList<String>();
        /**
         * calculate the maximum frequency of any character 
         * required for all words in 'words2'
         */
        int[] freq = new int[26];
        for (String word : words2) {             // TC: O(M) 
            int[] temp = new int[26];
            for (char ch : word.toCharArray()) { // TC: O(L)
                temp[ch - 'a']++;
                freq[ch - 'a'] = Math.max(freq[ch - 'a'], temp[ch - 'a']);
            }
        }
        // mapping the same frequency for each word in 'words1'
        for (String word : words1) {             // TC: O(N) 
            int[] temp = new int[26];
            for (char ch : word.toCharArray()) { // TC: O(L)
                temp[ch - 'a']++;
            }
            // check if freq is a subset of temp
            if (isSubSet(freq, temp)) {       // TC: O(1), SC: O(1)
                uni.add(word);
            }
        }
        return uni;
    }

    /**
     * TC: O(26) ~ O(1)
     * SC: O(1)
     */
    private boolean isSubSet(int[] freq, int[] temp) {
        for (int i = 0; i < 26; i++) {        // TC: O(26) ~ O(1)
            if (freq[i] > temp[i]) {
                // not a subset
                return false;
            }
        }
        return true;
    }
}
