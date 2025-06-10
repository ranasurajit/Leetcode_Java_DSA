class Solution {
    /**
     * Approach I : Using Hashing Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int maxDifference(String s) {
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
