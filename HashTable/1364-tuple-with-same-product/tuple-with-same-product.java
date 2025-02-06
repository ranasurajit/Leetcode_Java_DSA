class Solution {
    /**
     * Using Hashing Approach
     *
     * TC: O(N ^ 2) ~ O(N ^ 2)
     * SC: O(N)
     */
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        int pairs = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                int prod = nums[i] * nums[j];
                pairs += 8 * map.getOrDefault(prod, 0);
                map.put(prod, map.getOrDefault(prod, 0) + 1);
            }
        }
        return pairs;
    }
}
