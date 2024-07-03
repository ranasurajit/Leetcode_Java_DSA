class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if (n <= 4) {
            return 0;
        }
        int diff = Integer.MAX_VALUE;
        diff = Math.min(diff, nums[n - 1] - nums[3]);
        diff = Math.min(diff, nums[n - 4] - nums[0]);
        diff = Math.min(diff, nums[n - 2] - nums[2]);
        diff = Math.min(diff, nums[n - 3] - nums[1]);
        return diff;
    }
}
