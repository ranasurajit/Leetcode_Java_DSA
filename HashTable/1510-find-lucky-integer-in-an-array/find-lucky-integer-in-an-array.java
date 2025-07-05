class Solution {
    /**
     * Approach II : Using Frequency Array Approach
     *
     * TC: O(N) + O(500) ~ O(N)
     * SC: O(500) ~ O(1)
     */
    public int findLucky(int[] arr) {
        int[] freqMap = new int[501]; // SC: O(500)
        for (int num : arr) { // TC: O(N)
            freqMap[num]++;
        }
        for (int i = 500; i >= 1; i--) { // TC: O(500)
            if (freqMap[i] == i) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Approach I : Using Hashing Approach
     *
     * TC: O(N) + O(N) ~ O(N)
     * SC: O(N)
     */
    public int findLuckyHashing(int[] arr) {
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
