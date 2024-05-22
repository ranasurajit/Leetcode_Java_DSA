class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            leftSum = i == 0 ? 0 : leftSum + nums[i - 1];
            prefix[i] = leftSum;
        }
        int rightSum = 0;
        int minIndex = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            rightSum = i == n - 1 ? 0 : rightSum + nums[i + 1];
            if (prefix[i] == rightSum) {
                if (minIndex > i) {
                    minIndex = i;
                }
            }
        }
        return minIndex == Integer.MAX_VALUE ? - 1 : minIndex;
    }
}
