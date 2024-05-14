class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[] count = {0};
        numWays(0, 0, nums, count, target);
        return count[0];
    }

    private void numWays(int index, int sum, int[] nums, int[] count, int target) {
        if (index == nums.length) {
            if (sum == target) {
                count[0]++;
            }
            return;
        }
        // add
        numWays(index + 1, sum + nums[index], nums, count, target);
        // substract
        numWays(index + 1, sum - nums[index], nums, count, target);
    }
}