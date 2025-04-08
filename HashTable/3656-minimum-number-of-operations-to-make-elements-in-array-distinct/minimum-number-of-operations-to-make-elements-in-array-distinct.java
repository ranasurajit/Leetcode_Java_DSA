class Solution {
    /**
     * Approach I : Using Hashing Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        int operations = 0;
        for (int p = 0; p < n; p++) { // TC: O(N)
            map.put(nums[p], map.getOrDefault(nums[p], 0) + 1);
        }
        if (map.size() == n) {
            return operations;
        }
        int count = n;
        for (int i = 0; i < n; i += 3) { // TC: O(N / 3)
            for (int j = i; j < n && j < i + 3; j++) { // TC: O(3)
                map.put(nums[j], map.get(nums[j]) - 1);
                if (map.get(nums[j]) == 0) {
                    map.remove(nums[j]);
                }
            }
            operations++;
            count -= 3;
            if (map.size() == 0 || map.size() == count) {
                break;
            }
        }
        return operations;
    }
}
