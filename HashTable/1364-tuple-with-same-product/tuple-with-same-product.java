class Solution {
    /**
     * Using Hashing Approach
     *
     * TC: O(N ^ 2 + N) ~ O(N ^ 2)
     * SC: O(N)
     */
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                int prod = nums[i] * nums[j];
                map.put(prod, map.getOrDefault(prod, 0) + 1);
            }
        }
        int pairs = 0;
        for (Integer key : map.keySet()) { // TC: O(N)
            if (map.get(key) > 1) {
                int p = map.get(key);
                pairs += (p * (p - 1)) / 2;
            }
        }
        // for each pair products, 8 tuples can be created
        return 8 * pairs;
    }
}
