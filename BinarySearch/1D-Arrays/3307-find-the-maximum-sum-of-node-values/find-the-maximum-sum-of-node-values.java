class Solution {
    /**
     * Approach : Using Greedy Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        long idealSum = 0;
        int count = 0;
        int minLoss = Integer.MAX_VALUE;
        for (int num : nums) { // TC: O(N)
            if ((num ^ k) > num) {
                idealSum += (num ^ k);
                count++;
            } else {
                idealSum += num;
            }
            minLoss = Math.min(minLoss, Math.abs(num - (num ^ k)));
        }
        return (count & 1) == 0 ? idealSum : idealSum - minLoss;
    }
}
