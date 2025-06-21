class Solution {
    /**
     * Approach : Using Greedy + Sorting + Hashing Approach
     *
     * Intuition : Sort the frequency of characters and then for each freq f the 
     * TC: O(N)
     * SC: O(1)
     */
    public int minimumDeletions(String word, int k) {
        int n = word.length();
        int[] freqMap = new int[26];  // SC: O(26) ~ O(1)
        for (int i = 0; i < n; i++) { // TC: O(N)
            freqMap[word.charAt(i) - 'a']++;
        }
        List<Integer> freqList = new ArrayList<Integer>();
        for (int i = 0; i < 26; i++) { // TC: O(26)
            if (freqMap[i] > 0) {
                freqList.add(freqMap[i]);
            }
        }
        // Sort the freqList to compare from minimum to maximum frequencies
        Collections.sort(freqList); // TC: O(26 x log(26)) ~ O(1)
        int minDeletions = Integer.MAX_VALUE;
        for (int i = 0; i < freqList.size(); i++) { // TC: O(26)
            int baseFreq = freqList.get(i);
            int deletions = 0;
            for (int j = 0; j < freqList.size(); j++) { // TC: O(26)
                int currentFreq = freqList.get(j);
                // currentFreq should be in range of baseFreq + k
                if (currentFreq < baseFreq) {
                    deletions += currentFreq;
                } else if (currentFreq > baseFreq + k) {
                    deletions += (currentFreq - (baseFreq + k));
                }
            }
            minDeletions = Math.min(minDeletions, deletions);
        }
        return minDeletions;
    }
}
