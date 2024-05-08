class Solution {
    public int missingNumber(int[] nums) {
        int missing = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            missing = missing ^ nums[i] ^ i;
        }
        return missing ^ len;
    }
}
