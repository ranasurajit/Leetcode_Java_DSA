class Solution {
    /**
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int numberOfGoodPartitions(int[] nums) {
        int mod = (int) 1e9 + 7;
        int n = nums.length;
        // storing the last occurence index of each elements in nums
        HashMap<Integer, Integer> lastIndexMap = 
            new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) {        // TC: O(N)
            lastIndexMap.put(nums[i], i);
        }
        int i = 0;
        int j = 0;
        j = Math.max(j, lastIndexMap.get(nums[0]));
        int count = 1;
        while (i < n) {                     // TC: O(N)
            if (i > j) {
                count = (count * 2) % mod;
            }
            j = Math.max(j, lastIndexMap.get(nums[i]));
            i++;
        }
        return count;
    }
}
