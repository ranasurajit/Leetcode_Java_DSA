class Solution {
    /**
     * Approach : Using Hashing Approach
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // Map to store the frequencies of prefix-sum { prefixSum, count }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        map.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            prefixSum += nums[i];
            int reqSum = prefixSum - k;
            if (map.containsKey(reqSum)) {
                count += map.get(reqSum);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
