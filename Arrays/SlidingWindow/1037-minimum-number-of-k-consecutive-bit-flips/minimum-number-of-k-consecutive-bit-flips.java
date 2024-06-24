class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flips = 0;
        int flipsTillIndex = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k && nums[i - k] == -1) {
                flipsTillIndex--;
            }
            if (flipsTillIndex % 2 == nums[i]) {
                if (i + k > n) {
                    return -1;
                }
                nums[i] = -1;
                flipsTillIndex++;
                flips++;
            }
        }
        return flips;
    }
}
