class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }
        int head = 0;
        int tail = n - 1;
        int[] sorted = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (nums[head] > nums[tail]) {
                sorted[i] = nums[head];
                head++;
            } else {
                sorted[i] = nums[tail];
                tail--;
            }
        }
        return sorted;
    }
}
