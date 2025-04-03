class Solution {
    /**
     * Approach: Using Hashing Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        // store { cumulativeSum, index } in HashMap
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        /**
         * add { 0, -1 } to the map so that if a subarray 
         * starts from index 0, size can be calculated from
         * index difference = i - map.get(cumulativeSum)
         */
        map.put(0, -1);
        int cumulativeSum = 0;
        int maxLength = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            cumulativeSum += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(cumulativeSum)) {
                maxLength = Math.max(maxLength, i - map.get(cumulativeSum));
            } else {
                map.put(cumulativeSum, i);
            }
        }
        return maxLength;
    }
}
