class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int subArraysCount = 0;
        int n = nums.length;
        // HashMap to store the count of odd numbers till ith element and frequency of that
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(0, 1);
        int countOdds = 0;
        for (int i = 0; i < n; i++) {
            // if num is odd then returns 1 else 0
            countOdds += nums[i] % 2;
            // checks if (countOdds - k) exists in HashMap and returns the count
            subArraysCount += hm.getOrDefault(countOdds - k, 0);
            hm.put(countOdds, hm.getOrDefault(countOdds, 0) + 1);
        }
        return subArraysCount;
    }
}
