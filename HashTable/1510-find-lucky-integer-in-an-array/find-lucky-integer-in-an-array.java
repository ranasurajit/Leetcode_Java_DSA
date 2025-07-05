class Solution {
    /**
     * Approach : Using Hashing Approach
     *
     * TC: O(N) + O(N) ~ O(N)
     * SC: O(N)
     */
    public int findLucky(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }
        int result = 0;
        for (Integer key : freqMap.keySet()) { // TC: O(N)
            if (freqMap.get(key) == key) {
                result = Math.max(result, key);
            }
        }
        return result == 0 ? -1 : result;
    }
}
