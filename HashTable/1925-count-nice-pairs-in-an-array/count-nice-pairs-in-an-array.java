class Solution {
    private static final int MOD = (int) 1e9 + 7;

    /**
     * Approach II : Using Hashing Approach
     *
     * TC: O(N x L)
     * SC: O(N)
     *
     * where L = average count of digits in nums i.e. 1 <= L <= 10
     */
    public int countNicePairs(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> revMap = new HashMap<Integer, Integer>(); // SC: O(N)
        /**
         * In these problems where we have relation between (i, j) and (j, i) as below: 
         * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
         * bring all i variables and j variables together so arange it as below: 
         * nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])
         */
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int key = nums[i] - rev(nums[i]); // TC: O(L)
            count = (count + revMap.getOrDefault(key, 0)) % MOD;
            revMap.put(key, (revMap.getOrDefault(key, 0) + 1) % MOD);
        }
        return count % MOD;
    }

    /**
     * Approach I : Using Hashing Approach
     *
     * TC: O(N x L + N x N) ~ O(N x (L + N))
     * SC: O(N)
     */
    public int countNicePairsApproachI(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> revMap = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            revMap.put(nums[i], rev(nums[i])); // TC: O(L)
        }
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (i == j) {
                    continue;
                }
                if (nums[i] + revMap.get(nums[j]) == nums[j] + revMap.get(nums[i])) {
                    count++;
                }
            }
        }
        return count / 2;
    }

    /**
     * TC: O(L)
     * SC: O(1)
     */
    private int rev(int num) {
        int result = 0;
        while (num > 0) {
            int rem = num % 10; // 2
            num = num / 10; // 4
            result = result * 10 + rem;
        }
        return result;
    }
}
