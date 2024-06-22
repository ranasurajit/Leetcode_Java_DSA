class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int subArraysCount = 0;
        int n = nums.length;
        int[] prefixOdds = new int[n + 1];
        prefixOdds[0] = 1;
        int countOdds = 0;
        for (int i = 0; i < n; i++) {
            // if num is odd then returns 1 else 0
            countOdds += (nums[i] & 1);
            if (countOdds - k >= 0) {
                subArraysCount += prefixOdds[countOdds - k];
            }
            prefixOdds[countOdds]++;
        }
        return subArraysCount;
    }
}
