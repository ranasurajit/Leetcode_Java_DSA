class Solution {
    /**
     * Approach I : Brute-Force Approach Using Hashing
     *
     * TC: O(N + N ^ 2) ~ O(N ^ 2)
     * SC: O(N)
     */
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int num : nums) { // TC: O(N)
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int k = map.size(); // number of distinct elements in the array 'nums'
        map.clear();
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = i; j < n; j++) { // TC: O(N)
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                if (map.size() == k) {
                    count++;
                }
            }
            map.clear(); // clearing map for next iteration
        }
        return count;
    }
}
