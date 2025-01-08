class Solution {
    /**
     * Using Two Pointers
     *
     * TC: O(N x log(N) + N ^ 2) ~ O(N ^ 2)
     * SC: O(1)
     */
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);                 // TC: O(N x log(N))
        int count = 0;
        // for a valid triangle sum of two sides > third side
        // fixing one side as largest one
        for (int i = n - 1; i >= 2; i--) { // TC: O(N)
            // Using Two Pointers to find other two sides
            int start = 0;
            int end = i - 1;
            while (start < end) {         // TC: O(N)
                int sum = nums[start] + nums[end];
                if (sum > nums[i]) {
                    // valid triangle condition satisfied
                    // all numbers between start and end will satisfy
                    count += (end - start);
                    // check for more by lowering end
                    end--;
                } else {
                    // valid triangle condition not satisfied
                    start++;
                }
            }
        }
        return count;
    }
}
