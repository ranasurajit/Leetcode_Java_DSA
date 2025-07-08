class Solution {
    /**
     * Approach : Using LIS and Previous Index Tracking Array Approach
     * 
     * TC: O(N x log(N)) + O(N) + O(N) + O(N) ~ O(N x log(N))
     * SC: O(N) + O(N) ~ O(N)
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        /**
         * here the order does not matter as we are looking for 
         * answer[i] % answer[j] == 0, or
         * answer[j] % answer[i] == 0
         */
        Arrays.sort(nums); // TC: O(N x log(N))
        List<Integer> lis = new ArrayList<Integer>();
        int[] dp = new int[n]; // SC: O(N)
        Arrays.fill(dp, 1); // minimum length of subset is 1
        int maxLength = 1;
        // to track the LIS
        List<Integer> track = new ArrayList<Integer>(); // SC: O(N)
        int lastIndex = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            track.add(i);
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] % nums[prev] == 0 && dp[prev] + 1 > dp[i]) {
                    dp[i] = dp[prev] + 1;
                    track.set(i, prev);
                }
            }
            if (maxLength < dp[i]) {
                maxLength = dp[i];
                lastIndex = i;
            }
        }
        lis.add(nums[lastIndex]);
        while (track.get(lastIndex) != lastIndex) { // TC: O(N)
            lastIndex = track.get(lastIndex);
            lis.add(nums[lastIndex]);
        }
        Collections.reverse(lis); // TC: O(N)
        return lis;
    }
}
