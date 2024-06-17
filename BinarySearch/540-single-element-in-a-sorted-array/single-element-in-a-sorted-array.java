class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }
        int low = 2;
        int high = n - 3;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            // check if nums[mid] is 2nd occurence so make it 1st occurence
            if (nums[mid] == nums[mid - 1]) {
                mid = mid - 1;
            }
            if (mid % 2 == 0) {
                // if mid occurs in even index
                low = mid + 2;
                if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                    // check if at even index element is not equal to its surrounding elements
                    return nums[mid];
                }
            } else {
                // if mid occurs in odd index
                if (nums[mid] == nums[mid + 1]) {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
