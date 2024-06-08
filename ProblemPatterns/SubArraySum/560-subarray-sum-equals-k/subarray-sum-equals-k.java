class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            // Applying to find prefixSum - k in array at index i
            int diff = prefixSum - k;
            count += hm.getOrDefault(diff, 0);
            hm.put(prefixSum, hm.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
