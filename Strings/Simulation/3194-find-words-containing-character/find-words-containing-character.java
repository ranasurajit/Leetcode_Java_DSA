class Solution {
    /**
     * Approach II : Using Character Comparison Approach
     *
     * TC: O(N x L), where L = MaxLength(words[i])
     * SC: O(1)
     */
    public List<Integer> findWordsContaining(String[] words, char x) {
        int n = words.length;
        List<Integer> indices = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) { // TC: O(N)
            String word = words[i];
            for (int j = 0; j < word.length(); j++) { // TC: O(L)
                if (word.charAt(j) == x) {
                    indices.add(i);
                    break;
                }
            }
        }
        return indices;
    }

    /**
     * Approach I : Using String Simulation Approach
     *
     * TC: O(N ^ 2)
     * SC: O(1)
     */
    public List<Integer> findWordsContainingApproachI(String[] words, char x) {
        int n = words.length;
        List<Integer> indices = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (words[i].indexOf(x) > -1) { // TC: O(N)
                indices.add(i);
            }
        }
        return indices;
    }
}
