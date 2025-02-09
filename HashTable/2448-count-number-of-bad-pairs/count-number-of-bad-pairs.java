class Solution {
    /**
     * Using Hashing Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        /**
         * deduce this problem of j - i != nums[j] - nums[i] 
         * as 
         * (nums[i] - i) != (nums[j] - j)
         * so, pre-process this in the same array 'nums'
         */
        for (int i = 0; i < n; i++) { // TC: O(N)
            nums[i] = nums[i] - i;
        }
        /**
         * store the frequencies of each nums[i] to check how many
         * different numbers found in the left of a particular 
         * index so that it makes a bad pair
         */
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        long badPairsCount = 0L;
        long badPairs = 0L;
        long goodPairs = 0L;
        for (int i = 0; i < n; i++) { // TC: O(N)
            badPairs = i;
            goodPairs = map.getOrDefault(nums[i], 0);
            // match count will make good pairs
            badPairsCount += (badPairs - goodPairs);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return badPairsCount;
    }

    /**
     * Using Brute-Force Approach
     *
     * TC: O(N ^ 2)
     * SC: O(1)
     */
    public long countBadPairsBruteForce(int[] nums) {
        int n = nums.length;
        long count = 0L;
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                if (j - i != nums[j] - nums[i]) {
                    count++;
                }
            }
        }
        return count;
    }
}
