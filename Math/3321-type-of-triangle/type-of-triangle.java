class Solution {
    /**
     * Approach : Using Math Approach
     *
     * TC: O(1)
     * SC: O(1)
     */
    public String triangleType(int[] nums) {
        if (nums[0] + nums[1] > nums[2] && nums[1] + nums[2] > nums[0] && nums[2] + nums[0] > nums[1]) {
            if (nums[0] != nums[1] && nums[1] != nums[2] && nums[2] != nums[0]) {
                return "scalene";
            } else if (nums[0] == nums[1] && nums[1] == nums[2] && nums[2] == nums[0]) {
                return "equilateral";
            } else {
                return "isosceles";
            }
        } else {
            return "none";
        }
    }
}
