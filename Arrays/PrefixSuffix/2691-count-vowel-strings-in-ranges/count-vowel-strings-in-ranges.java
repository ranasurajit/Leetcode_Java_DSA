class Solution {
    /**
     * TC: O(N + Q)
     * SC: O(N)
     */
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] precompute = new int[n];        // SC: O(N)
        precompute[0] = isVowelWord(words[0]) ? 1 : 0;
        for (int i = 1; i < n; i++) {         // TC: O(N)
            int count = isVowelWord(words[i]) ? 1 : 0;
            precompute[i] = precompute[i - 1] + count;
        }
        int q = queries.length;
        int[] result = new int[q];            // SC: O(Q) - ignored as it is to be returned
        for (int i = 0; i < q; i++) {         // TC: O(Q)
            if (queries[i][0] == 0) {
                result[i] = precompute[queries[i][1]];
            } else {
                result[i] = precompute[queries[i][1]] - precompute[queries[i][0] - 1];
            }
        }
        return result;
    }

    /**
     * TC: O(K), where as per constraints, 1 <= K <= 40 ~ O(1)
     * SC: O(1)
     */
    private boolean isVowelWord(String word) {
        String vowels = "aeiou";
        int size = word.length();
        return vowels.indexOf(word.charAt(0)) >= 0 &&
            vowels.indexOf(word.charAt(size - 1)) >= 0;
    }
}
