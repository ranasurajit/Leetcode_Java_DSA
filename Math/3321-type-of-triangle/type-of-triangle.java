class Solution {
    /**
     * Approach : Using Sorting and Hashing Approach
     *
     * TC: O(1)
     * SC: O(1)
     */
    public String triangleType(int[] nums) {
        Arrays.sort(nums); // TC: O(3 x log(3)) ~ O(1)
        Set<Integer> set = new HashSet<Integer>(); // SC: O(3) ~ O(1)
        for (int num : nums) { // TC: O(3) ~ O(1)
            set.add(num);
        }
        if (nums[0] + nums[1] <= nums[2]) {
            return "none";
        }
        if (set.size() == 1) {
            return "equilateral";
        } else if (set.size() == 2) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }

    /**
     * Approach : Using Math Brute-Force Approach
     *
     * TC: O(1)
     * SC: O(1)
     */
    public String triangleTypeBruteForce(int[] nums) {
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
