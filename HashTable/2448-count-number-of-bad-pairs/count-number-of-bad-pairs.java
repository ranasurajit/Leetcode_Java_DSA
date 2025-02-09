class Solution {
    /**
     * Using Optimization Hashing Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        long badPairs = 0L;
        for (int i = 0; i < n; i++) { // TC: O(N)
            // we will deduce (nums[i] - i) in same loop
            int diff = nums[i] - i;
            long goodPairs = map.getOrDefault(diff, 0);
            long totalPairs = i;
            badPairs += totalPairs - goodPairs;
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        return badPairs;
    }
}
