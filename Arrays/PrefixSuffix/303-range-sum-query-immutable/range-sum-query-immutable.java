class NumArray {

    private int[] prefix;

    public NumArray(int[] nums) {
        int n = nums.length;
        this.prefix = new int[n];
        this.prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            this.prefix[i] = nums[i] + this.prefix[i - 1];
        }
    }
    
    public int sumRange(int left, int right) {
        int leftVal = left > 0 ? this.prefix[left - 1] : 0;
        int rightVal = this.prefix[right];
        return rightVal - leftVal;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
