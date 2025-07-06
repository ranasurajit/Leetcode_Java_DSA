/**
 * Approach : Using Hashing Approach
 *
 * TC: O(N1 + N2)
 * SC: O(N1 + N2)
 */
class FindSumPairs {

    int[] nums1;
    int[] nums2;

    Map<Integer, Integer> map1 = new HashMap<Integer, Integer>(); // SC: O(N1)
    Map<Integer, Integer> map2 = new HashMap<Integer, Integer>(); // SC: O(N2)

    /**
     * Creating HashMap map1 and map2 from arrays nums1 and nums2 respectively
     *
     * TC: O(N1 + N2)
     * SC: O(N1 + N2)
     */
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for (int num : nums1) { // TC: O(N1)
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) { // TC: O(N2)
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
    }
    
    /**
     * Updating nums2 array and HashMap map2
     *
     * TC: O(1)
     * SC: O(1)
     */
    public void add(int index, int val) {
        int oldValue = nums2[index];
        map2.put(oldValue, map2.getOrDefault(oldValue, 0) - 1);
        if (map2.get(oldValue) == 0) {
            map2.remove(oldValue);
        }
        int newValue = oldValue + val;
        nums2[index] = newValue;
        map2.put(newValue, map2.getOrDefault(newValue, 0) + 1);
    }
    
    /**
     * Looping over the HashMap
     *
     * TC: O(N1)
     * SC: O(1)
     */
    public int count(int tot) {
        int pairs = 0;
        for (Integer key : map1.keySet()) { // TC: O(N1)
            int diff = tot - key;
            if (map2.containsKey(diff)) {
                int freq1 = map1.get(key);
                int freq2 = map2.get(diff);
                pairs += (freq1 * freq2);
            }
        }
        return pairs;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
