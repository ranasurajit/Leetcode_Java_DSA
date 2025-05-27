class Solution {
    /**
     * Approach : Using Hashing Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        // we will store {nums[i], i} in the HashMap
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (map.containsKey(nums[i])) {
                int diff = Math.abs(map.get(nums[i]) - i);
                if (diff <= k) {
                    return true;
                } else {
                    /**
                     * if diff > k, then we will override the index with a 
                     * hope that we will encounter the same value as nums[i] 
                     * with an index - currentIndex <= k
                     */
                    map.put(nums[i], i);
                }
            } else {
                 map.put(nums[i], i);
            }
        }
        return false;
    }
}
