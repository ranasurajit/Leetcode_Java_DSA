class Solution {
    /**
     * Approach II : Using Dutch National Flag Algorithm / Two Pointers Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;
        while (mid <= high) { // TC: O(N)
            if (nums[mid] == 0) {
                // swap elements from index low and mid
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                // swap elements from index high and mid
                swap(nums, high, mid);
                high--;
            }
        }
    }

    /**
     * Swap Array elements from index p to q
     *
     * TC: O(1)
     * SC: O(1)
     */
    private void swap(int[] nums, int p, int q) {
        int temp = nums[q];
        nums[q] = nums[p];
        nums[p] = temp;
    }

    /**
     * Approach I : Using Hashing Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(3) ~ O(1)
     */
    public void sortColorsApproachI(int[] nums) {
        int n = nums.length;
        int[] map = new int[3];
        for (int i = 0; i < n; i++) {  // TC: O(N)
            map[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < 3; i++) {  // TC: O(N)
            int size = map[i];
            for (int j = 0; j < size; j++) {
                nums[index++] = i;
            }
        }
    }
}
