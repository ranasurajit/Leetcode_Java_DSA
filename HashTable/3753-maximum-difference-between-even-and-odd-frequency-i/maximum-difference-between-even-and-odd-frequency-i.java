class Solution {
    /**
     * Approach II : Using Hashing (Array) Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int maxDifference(String s) {
        int n = s.length();
        int[] freqMap = new int[26]; // SC: O(26) ~ O(1)
        for (int i = 0; i < n; i++) { // TC: O(N)
            freqMap[s.charAt(i) - 'a']++;
        }
        /**
         * To maximize the (odd - even) frequency difference we need
         * maximum odd frequency and minimum even frequency
         */
        int maxOddFrequency = -1;
        int minEvenFrequency = n;
        for (int i = 0; i < 26; i++) { // TC: O(26)
            if (freqMap[i] != 0) {
                if ((freqMap[i] & 1) == 0) {
                    // even frequency
                    minEvenFrequency = Math.min(minEvenFrequency, freqMap[i]);
                } else {
                    // odd frequency
                    maxOddFrequency = Math.max(maxOddFrequency, freqMap[i]);
                }
            }
        }
        return maxOddFrequency - minEvenFrequency;
    }

    /**
     * Approach I : Using Hashing Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int maxDifferenceUsingHashMap(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        /**
         * To maximize the (odd - even) frequency difference we need
         * maximum odd frequency and minimum even frequency
         */
        int maxOddFrequency = -1;
        int minEvenFrequency = n;
        for (Character key : map.keySet()) { // TC: O(N)
            int freq = map.get(key);
            if ((freq & 1) == 0) {
                // even frequency
                minEvenFrequency = Math.min(minEvenFrequency, freq);
            } else {
                // odd frequency
                maxOddFrequency = Math.max(maxOddFrequency, freq);
            }
        }
        return maxOddFrequency - minEvenFrequency;
    }
}
