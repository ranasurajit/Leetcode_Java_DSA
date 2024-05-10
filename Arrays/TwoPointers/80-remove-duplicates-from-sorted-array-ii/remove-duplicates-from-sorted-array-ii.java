class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int it : nums) {
            if (index == 0 || index == 1 || nums[index - 2] != it) {
                nums[index] = it;
                index++;
            }
        }
        return index;
    }
}
