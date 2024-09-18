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

    /**
     * Brute-Force Approach
     * 
     * TC: O(N^2)
     * SC: O(1)
     * 
     * @param nums
     * @param k
     * @return
     */
    public int countKDifferenceBruteForce(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                if (Math.abs(nums[j] - nums[i]) == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
