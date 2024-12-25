class Solution {
    /**
     * Using Sliding Window Approach
     *
     * TC: O(N x log(K)) and K <= 2 so TC: O(N)
     * SC: O(1) as in TreeMap we are storing at max elements with difference <= 2
     */
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        /*
         * In sliding window we need to check difference between 
         * largest and smallest value if diff <= 2 then window 
         * will be valid
         */
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        long count = 0;
        for (int i = 0, j = 0; j < n; j++) {                  // TC: O(N)
            tm.put(nums[j], tm.getOrDefault(nums[j], 0) + 1); // TC: O(log(K))
            // shrinking the start index 'i' when |nums[j] - nums[i]| > 2
            while (Math.abs(tm.lastKey() - tm.firstKey()) > 2) {
                if (tm.get(nums[i]) > 1) {
                    tm.put(nums[i], tm.get(nums[i]) - 1);
                } else {
                    tm.remove(nums[i]);
                }
                i++;
            }
            // count all the sub-arrays which satisfies |nums[j] - nums[i]| <= 2
            count += (j - i + 1);
        }
        return count;
    }
}
