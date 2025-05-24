class Solution {
    /**
     * Approach : Using Hashing Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }
        Set<Integer> freqSet = new HashSet<Integer>(); // SC: O(N)
        for (Integer key : freqMap.keySet()) { // TC: O(N)
            int currentFreq = freqMap.get(key);
            if (freqSet.contains(currentFreq)) {
                return false;
            }
            freqSet.add(currentFreq);
        }
        return true;
    }
}
