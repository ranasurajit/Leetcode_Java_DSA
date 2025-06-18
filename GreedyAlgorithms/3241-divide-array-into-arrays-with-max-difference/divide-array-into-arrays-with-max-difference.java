class Solution {
    /**
     * Approach I : Using Greedy + Sorting Approach (Cleaner Approach)
     *
     * TC: O(N x log(N) + N / 3) ~ O(N x log(N))
     * SC: O(1)
     */
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums); // TC: O(N x log(N))
        int[][] result = new int[n / 3][3];
        for (int i = 0; i < n; i+=3) { // TC: O(N / 3)
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][0];
            }
            result[i / 3] = new int[] { nums[i], nums[i + 1], nums[i + 2] };
        }
        return result;
    }

    /**
     * Approach I : Using Greedy + Sorting Approach
     *
     * TC: O(N x log(N) + 3 x N) ~ O(N x log(N))
     * SC: O(1)
     */
    public int[][] divideArrayApproachI(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums); // TC: O(N x log(N))
        int[][] result = new int[n / 3][3];
        for (int i = 0; i < n - 2; i++) { // TC: O(N)
            int j = 0;
            result[i/3][j] = nums[i];
            for (j = 1; j < 3; j++) { // TC: O(3)
                if (nums[j + i] - nums[i] <= k) {
                    result[i/3][j] = nums[j + i];
                } else {
                    return new int[][] {};
                }
            }
            i = i + 2;
        }
        return result;
    }
}
