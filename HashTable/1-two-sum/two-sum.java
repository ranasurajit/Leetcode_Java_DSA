class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        // we will store { nums[i], i } in HashMap
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[] { map.get(diff), i };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }
}
