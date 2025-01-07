class Solution {
    /**
     * Brute-Force Approach
     *
     * TC: O(K x N^2)
     * SC: O(1)
     */
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        Set<String> set = new HashSet<String>(); // SC: O(N)
        for (int i = 0; i < n; i++) {     // TC: O(N)
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (i != j && isSubString(words[i], words[j])) { // TC: O(K)
                    set.add(words[i]);
                }
            }
        }
        return new ArrayList<String>(set);
    }

    /**
     * TC: O(K), where K = length of word
     * SC: O(1)
     */
    private boolean isSubString(String subWord, String word) {
        return word.indexOf(subWord) > -1;
    }
}
