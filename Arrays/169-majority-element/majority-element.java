class Solution {
    public int majorityElement(int[] nums) {
        int major = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
            }
            count = nums[i] == major ? count + 1 : count - 1;
        }
        return major;
    }
}
