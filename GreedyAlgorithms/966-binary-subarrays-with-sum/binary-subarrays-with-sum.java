class Solution {
    /**
     * Approach I : Using Hashing Approach
     * 
     * Problem is similar to count sub-arrays with sum = k (goal)
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        // storing { prefixSum , frequency } in HashMap
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        map.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        int i = 0;
        while (i < n) { // TC: O(N)
            prefixSum += nums[i];
            int reqSum = prefixSum - goal;
            if (map.containsKey(reqSum)) {
                count += map.get(reqSum);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
            i++;
        }
        return count;
    }
}
