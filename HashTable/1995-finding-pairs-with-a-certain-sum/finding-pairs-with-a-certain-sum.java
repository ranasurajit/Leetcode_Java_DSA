class FindSumPairs {

    Map<Long, Long> map1 = null;
    Map<Long, Long> map2 = null;
    int[] nums1;
    int[] nums2;

    /**
     * Creating HashMap map1 and map2 from arrays nums1 and nums2 respectively
     *
     * TC: O(N1 + N2)
     * SC: O(N1 + N2)
     */
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        map1 = new HashMap<Long, Long>(); // SC: O(N1)
        map2 = new HashMap<Long, Long>(); // SC: O(N2)
        int n1 = nums1.length;
        int n2 = nums2.length;
        for (int i = 0; i < n1; i++) { // TC: O(N1)
            map1.put((long) nums1[i], map1.getOrDefault((long) nums1[i], 0L) + 1);
        }
        for (int i = 0; i < n2; i++) { // TC: O(N2)
            map2.put((long) nums2[i], map2.getOrDefault((long) nums2[i], 0L) + 1);
        }
    }
    
    /**
     * Updating nums2 array and HashMap map2
     *
     * TC: O(1)
     * SC: O(1)
     */
    public void add(int index, int val) {
        long oldValue = (long) nums2[index];
        map2.put(oldValue, map2.getOrDefault(oldValue, 0L) - 1);
        if (map2.get(oldValue) == 0) {
            map2.remove(oldValue);
        }
        long newValue = oldValue + val;
        nums2[index] = (int) newValue;
        map2.put(newValue, map2.getOrDefault(newValue, 0L) + 1);
    }
    
    /**
     * Looping over the HashMap
     *
     * TC: O(N1)
     * SC: O(1)
     */
    public int count(int tot) {
        long pairs = 0;
        for (Long key : map1.keySet()) { // TC: O(N1)
            long diff = (long) tot - key;
            if (map2.containsKey(diff)) {
                long freq1 = map1.get(key);
                long freq2 = map2.get(diff);
                pairs += (freq1 * freq2);
            }
        }
        return (int) pairs;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
