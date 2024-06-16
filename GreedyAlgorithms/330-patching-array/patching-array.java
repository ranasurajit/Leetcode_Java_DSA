class Solution {
    public int minPatches(int[] nums, int n) {
        long maxReach = 0;
        int patches = 0;
        int i = 0;
        while (maxReach < n) {
            if (i < nums.length && nums[i] <= maxReach + 1) {
                maxReach += (long) nums[i];
                i++;
            } else {
                maxReach += (long) (maxReach + 1);
                patches++;
            }
        }
        return patches;
    }
}
