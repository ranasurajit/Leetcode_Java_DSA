class Solution {
    /**
     * Approach I : Using String Simulation Approach
     *
     * TC: O(N ^ 2)
     * SC: O(1)
     */
    public List<Integer> findWordsContaining(String[] words, char x) {
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
