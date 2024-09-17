class Solution {
    /**
     * TC: O(2M + 2N) ~ O(M + N), where M and N are number of words in s1 and s2
     * SC: O(3M + 3N) ~ O(M + N)
     */
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>(); // SC: O(M + N)
        String[] words1 = s1.split(" "); // SC: O(M)
        String[] words2 = s2.split(" "); // SC: O(N)
        for (String word : words1) { // TC: O(M)
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) { // TC: O(N)
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }
        int size = 0;
        for (String key : hm.keySet()) { // TC: O(M + N)
            if (hm.get(key) == 1) {
                size++;
            }
        }
        String[] uncommon = new String[size]; // SC: O(M + N) ~ O(1) ignored as it is output
        int index = 0;
        for (String key : hm.keySet()) { // TC: O(M + N)
            if (hm.get(key) == 1) {
                uncommon[index++] = key;
            }
        }
        return uncommon;
    }
}
