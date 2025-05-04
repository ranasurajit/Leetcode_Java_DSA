class Solution {
    /**
     * Approach : Using Hashing Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<String, Integer>(); // SC: O(N)
        for (int[] pair : dominoes) { // TC: O(N)
            int low = pair[0] < pair[1] ? pair[0] : pair[1];
            int high = pair[0] < pair[1] ? pair[1] : pair[0];
            String key = low + "-" + high;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int count = 0;
        for (String key : map.keySet()) { // TC: O(N)
            int freq = map.get(key);
            if (freq > 1) {
                // number of pairs from count = nC2
                count += (freq * (freq - 1)) / 2;
            }
        }
        return count;
    }
}
