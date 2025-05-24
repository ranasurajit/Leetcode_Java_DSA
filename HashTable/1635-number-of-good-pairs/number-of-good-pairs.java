class Solution {
    /**
     * Approach : Using Hashing Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int num : nums) { // TC: O(N)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (Integer key : freqMap.keySet()) { // TC: O(N)
            int freq = freqMap.get(key);
            if (freq > 1) {
                count += (freq * (freq - 1)) / 2; // pairs = nC2 = (n * (n - 1)) / 2
            }
        }
        return count;
    }
}
