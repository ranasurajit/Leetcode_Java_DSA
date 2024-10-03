class Solution {
    /**
     * TC: O(N)
     * SC: O(N)
     */
    public int minSubarray(int[] nums, int p) {
        if (p == 1) {
            return 0;
        }
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            sum = (sum + nums[i]) % p;
        }
        int target = sum % p;
        if (target == 0) {
            return 0;
        }
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        hm.put(0, -1);
        sum = 0;
        int min = n;
        for (int i = 0; i < n; i++) { // TC: O(N)
            sum = (sum + nums[i]) % p;
            int diff = (sum - target + p) % p;
            if (hm.containsKey(diff)) {
                min = Math.min(min, i - hm.get(diff));
            }
            hm.put(sum % p, i);
        }
        return min == n ? -1 : min;
    }
}
