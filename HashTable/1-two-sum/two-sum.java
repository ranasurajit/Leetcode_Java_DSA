class Solution {
    /**
     * Using Hashing Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[] { -1, -1 };
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                result[0] = map.get(diff);
                result[1] = i;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
