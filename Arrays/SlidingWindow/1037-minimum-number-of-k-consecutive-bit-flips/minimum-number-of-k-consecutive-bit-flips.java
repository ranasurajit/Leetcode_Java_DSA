class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flips = 0;
        int flipsTillIndex = 0;
        boolean[] isFlipped = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (i >= k && isFlipped[i - k]) {
                flipsTillIndex--;
            }
            if (flipsTillIndex % 2 == nums[i]) {
                if (i + k > n) {
                    return -1;
                }
                isFlipped[i] = true;
                flipsTillIndex++;
                flips++;
            }
        }
        return flips;
    }
}
