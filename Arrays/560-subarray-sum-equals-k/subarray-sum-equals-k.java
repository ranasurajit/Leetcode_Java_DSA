class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(0, 1); 
        /* put inorder to ensure if a single element equals k is 
            present in nums the count can be incremented
        */
        int count = 0;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            int diff = currentSum - k;
            count += hm.getOrDefault(diff, 0);
            hm.put(currentSum, hm.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}
