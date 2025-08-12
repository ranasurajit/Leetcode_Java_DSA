class NumArray {
    private int n;
    private int[] nums;
    private long[] segTree;

    /**
     * Approach : Using Segment Tree Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(4 x N) + O(log(N)) ~ O(N) + O(log(N))
     */
    public NumArray(int[] nums) {
        n = nums.length;
        this.nums = nums;
        segTree = new long[4 * n]; // SC: O(4 x N)
        buildSegmentTree(0, 0, n - 1); // TC: O(N), SC: O(log(N)) 
    }

    /**
     * Approach : Using Segment Tree Approach
     *
     * TC: O(log(N))
     * SC: O(log(N))
     */
    public void update(int index, int val) {
        updateSegmentTree(index, val, 0, 0, n - 1);
    }

    /**
     * Approach : Using Segment Tree Approach
     *
     * TC: O(log(N))
     * SC: O(log(N))
     */
    public int sumRange(int left, int right) {
        return getRangeQuerySum(left, right, 0, 0, n - 1);
    }

    /**
     * Using Segment Tree Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(log(N))
     */
    private void buildSegmentTree(int segIdx, int left, int right) {
        // Base Case
        if (left == right) {
            segTree[segIdx] = nums[left];
            return;
        }
        // Recursion Leap of Faith
        int mid = left + (right - left) / 2;
        buildSegmentTree(segIdx * 2 + 1, left, mid);
        buildSegmentTree(segIdx * 2 + 2, mid + 1, right);
        segTree[segIdx] = segTree[2 * segIdx + 1] + segTree[2 * segIdx + 2];
    }

    /**
     * Using Segment Tree Approach
     *
     * TC: O(log(N))
     * SC: O(log(N))
     */
    private void updateSegmentTree(int index, int val, int segIdx, int left, int right) {
        // Base Case
        if (left == right) {
            segTree[segIdx] = val;
            return;
        }
        // Recursion Case
        int mid = left + (right - left) / 2;
        if (index <= mid) {
            updateSegmentTree(index, val, 2 * segIdx + 1, left, mid);
        } else {
            updateSegmentTree(index, val, 2 * segIdx + 2, mid + 1, right);
        }
        segTree[segIdx] = segTree[2 * segIdx + 1] + segTree[2 * segIdx + 2];
    }

    /**
     * Using Segment Tree Approach
     *
     * TC: O(log(N))
     * SC: O(log(N))
     */
    private int getRangeQuerySum(int start, int end, int segIdx, int left, int right) {
        // Base Case
        if (left > end || right < start) {
            // out of bounds
            return 0;
        }
        if (left >= start && right <= end) {
            return (int) segTree[segIdx];
        }
        // Recursion Calls
        // partial overlap
        int mid = left + (right - left) / 2;
        return getRangeQuerySum(start, end, 2 * segIdx + 1, left, mid) +
            getRangeQuerySum(start, end, 2 * segIdx + 2, mid + 1, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
