/**
 * Approach : Using Hashing Approach
 *
 * TC: O(N2)
 * SC: O(N2)
 */
class FindSumPairs {

    int[] nums1;
    int[] nums2;

    Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N2)

    /**
     * Creating HashMap map1 and map2 from arrays nums1 and nums2 respectively
     *
     * TC: O(N2)
     * SC: O(1)
     */
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for (int num : nums2) { // TC: O(N2)
            map.put(num, map.getOrDefault(num, 0) + 1);
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
        map.put(oldValue, map.getOrDefault(oldValue, 0) - 1);
        int newValue = oldValue + val;
        nums2[index] = newValue;
        map.put(newValue, map.getOrDefault(newValue, 0) + 1);
    }
    
    /**
     * Looping over the HashMap
     *
     * TC: O(N1)
     * SC: O(1)
     */
    public int count(int tot) {
        int pairs = 0;
        for (int num : nums1) { // TC: O(N1)
            int diff = tot - num;
            if (map.containsKey(diff)) {
                pairs += map.get(diff);
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
