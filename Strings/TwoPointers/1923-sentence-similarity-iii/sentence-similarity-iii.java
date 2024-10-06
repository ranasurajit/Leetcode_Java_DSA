class Solution {
    /**
     * TC: O(M + N)
     * SC: O(M + N)
     */
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // set sentence1 as smallest always if not swap it with sentence2
        if (sentence1.length() > sentence2.length()) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        List<String> sent1 = Arrays.asList(sentence1.split(" ")); // SC: O(M)
        List<String> sent2 = Arrays.asList(sentence2.split(" ")); // SC: O(N)

        int i = 0, j = sent1.size() - 1; // pointers for sent1
        int k = 0, l = sent2.size() - 1; // pointers for sent2
        // TC: O(M + N)
        while (i < sent1.size() && k < sent2.size() && sent2.get(k).equals(sent1.get(i))) {
            i++;
            k++;
        }
        while (i <= j && sent2.get(l).equals(sent1.get(j))) {
            j--;
            l--;
        }
        // return if pointers of sent1 crosses each other then we got the condition
        return i > j;
    }
}
