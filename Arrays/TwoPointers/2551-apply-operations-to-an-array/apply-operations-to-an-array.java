class Solution {
    /**
     * Approach II : Using A Different Result Array Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int index = 0;
        int i = 0;
        for (i = 0; i < n - 1; i++) { // TC: O(N)
            if (nums[i] != 0) {
                if (nums[i] == nums[i + 1]) {
                    result[index++] = 2 * nums[i];
                    i++;
                } else {
                    result[index++] = nums[i];
                }
            }
        }
        if (i < n) {
            result[index] = nums[i];
        }
        return result;
    }

    /**
     * Approach I : Using Two-Pointers Approach (In-place modification)
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public int[] applyOperationsApproachI(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) { // TC: O(N)
            if (nums[i] == nums[i + 1]) {
                nums[i] = 2 * nums[i];
                nums[i + 1] = 0;
            }
        }
        // Using Two-Pointers
        int p = 0;     // pointer from beginning index of array 'nums' 
        int q = 0;     // pointer from beginning index of array 'nums' 
        while (p < n) { // TC: O(N)
            while (p < n && nums[p] != 0) {
                p++;
            }
            // at this point pointer p points to zero element
            q = p + 1;
            while (q < n && nums[q] == 0) {
                q++;
            }
            // at this point pointer q points to non-zero element
            // swap nums[p] with nums[q]
            if (q < n) {
                int temp = nums[q];
                nums[q] = nums[p];
                nums[p] = temp;
            }
            p++;
            q++;
        }
        return nums;
    }
}
