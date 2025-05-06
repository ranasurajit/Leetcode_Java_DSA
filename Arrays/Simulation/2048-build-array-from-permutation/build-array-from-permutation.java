class Solution {
    /**
     * Approach II : Using In Place Operation
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) { // TC: O(N)
            nums[i] += 1000 * (nums[nums[i]] % 1000);
        }
        for (int i = 0; i < n; i++) { // TC: O(N)
            nums[i] = nums[i] / 1000;
        }
        return nums;
    }

    /**
     * Approach I : Using Simulation
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int[] buildArrayApproachI(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) { // TC: O(N)
            result[i] = nums[nums[i]];
        }
        return result;
    }
}
