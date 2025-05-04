class Solution {
    /**
     * Approach II : Using Two Pointers (One Pass) Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int idx = 0; // pointer at non-zero index
        int zeroIdx = 0; // pointer at zero index
        while (idx < n) { // TC: O(N)
            if (nums[idx] == 0) {
                idx++;
            } else {
                // swap elements at idx and zeroIdx
                int temp = nums[zeroIdx];
                nums[zeroIdx] = nums[idx];
                nums[idx] = temp;
                // move to next position
                zeroIdx++;
                idx++;
            }
        }
    }

    /**
     * Approach I : Using Two Pass Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public void moveZeroesApproachI(int[] nums) {
        int n = nums.length;
        int index = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while (index < n) { // TC: O(N)
            nums[index++] = 0;
        }
    }
}
