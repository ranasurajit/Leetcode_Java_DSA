class Solution {
    /**
     * Approach : Using Sliding Window Approach (Variable Length)
     *
     * TC: O(N)
     * SC: O(N)
     */
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        int i = 0; // pointer at the start of sliding window
        int j = 0; // pointer at the end of sliding window
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        long count = 0L;
        long pairs = 0L;
        while (j < n) { // TC: O(N)
            pairs += map.getOrDefault(nums[j], 0); // number of times we saw nums[j] before
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (pairs >= k) {
                count += (n - j); // count sub-arrays having k pairs
                // removing calculation from nums[i]
                int freq = map.get(nums[i]);
                if (freq == 1) {
                    map.remove(nums[i]);
                } else {
                    map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                }
                pairs -= map.getOrDefault(nums[i], 0);
                // shrinking the sliding window
                i++;
            }
            j++;
        }
        return count;
    }
}
