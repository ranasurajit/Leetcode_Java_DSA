class Solution {
    /**
     * Approach I : Using Hashing Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(3) ~ O(1)
     */
    public void sortColors(int[] nums) {
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
