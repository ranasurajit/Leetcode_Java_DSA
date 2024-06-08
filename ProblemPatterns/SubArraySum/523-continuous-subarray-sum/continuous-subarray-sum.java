class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        // Adding 0 at index -1 to HashMap in case if 0th element is multiple of k
        hm.put(0, -1);
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            if (k != 0) {
                // instead of finding multiple of k, we can find mod and store it further
                prefixSum = prefixSum % k;
            }
            /*
             * checking for all values inside HashMap if prefixSum is present after mod operation with k
             */
            if (hm.containsKey(prefixSum)) {
                if (i - hm.get(prefixSum) > 1) {
                    return true;
                }
            } else {
                hm.put(prefixSum, i);
            }
        }
        return false;
    }
}
