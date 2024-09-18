class Solution {
    /**
     * Optimal Approach
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param nums
     * @param k
     * @return
     */
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        int count = 0;
        for (int num : nums) { // TC: O(N)
            count += hm.getOrDefault(num + k, 0) + hm.getOrDefault(num - k, 0);
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        return count;
    }
}
