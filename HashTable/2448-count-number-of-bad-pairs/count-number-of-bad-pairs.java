class Solution {
    /**
     * Approach II : Using Hashing Approach
     * 
     * TC: O(N)
     * SC: O(N)
     *
     * Accepted (65 / 65 testcases passed)
     */
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        /**
         * we will convert the formula j - i != nums[j] - nums[i] into
         * nums[i] - i != nums[j] - j
         * so we will modify array 'nums'into nums[i] = (nums[i] - i)
         */
        Map<Integer, Long> freqMap = new HashMap<Integer, Long>(); // SC: O(N)
        long badPairs = 0L;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int diff = nums[i] - i;
            // good pairs will be how many diff values we encountered to left of index 'i'
            long goodPairs = freqMap.getOrDefault(diff, 0L);
            badPairs += (i - goodPairs);
            freqMap.put(diff, freqMap.getOrDefault(diff, 0L) + 1L);
        }
        return badPairs;
    }

    /**
     * Approach I : Using Brute-Force Approach
     * 
     * TC: O(N ^ 2)
     * SC: O(1)
     *
     * Time Limit Exceeded (59 / 65 testcases passed)
     */
    public long countBadPairsBruteForce(int[] nums) {
        int n = nums.length;
        long count = 0L;
        for (int i = 0; i < n - 1; i++) { // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                if (j - i != nums[j] - nums[i]) {
                    count++;
                }
            }
        }
        return count;
    }
}
