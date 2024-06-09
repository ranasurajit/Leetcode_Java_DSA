class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int rem = 0;
            if (k != 0) {
                rem = prefixSum % k;
            }
            if (rem < 0) {
                rem += k;
            }
            count = count + hm.getOrDefault(rem, 0);
            hm.put(rem, hm.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}
