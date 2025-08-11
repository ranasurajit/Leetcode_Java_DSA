class NumArray {
    private int[] segTree;
    private int[] nums;
    private int n;

    /**
     * Using Segment Tree Approach
     *
     * TC: O(N)
     * SC: O(4 x N) + O(log(N)) ~ O(N)
     */
    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        segTree = new int[4 * n]; // SC: O(4 x N)
        buildSegmentTree(0, 0, n - 1);
    }

    /**
     * Using Segment Tree Approach
     *
     * TC: O(N)
     * SC: O(log(N))
     */
    private void buildSegmentTree(int idx, int left, int right) {
        // Base Case
        if (left == right) {
            segTree[idx] = nums[left];
            return;
        }
        // Recursion Leap of Faith
        int mid = (left + right) / 2;
        buildSegmentTree(2 * idx + 1, left, mid);
        buildSegmentTree(2 * idx + 2, mid + 1, right);
        segTree[idx] = segTree[2 * idx + 1] + segTree[2 * idx + 2];
    }
 
    /**
     * Using Segment Tree Approach
     *
     * TC: O(log(N))
     * SC: O(log(N))
     */
    public void update(int index, int val) {
        updateSegmentTree(0, index, val, 0, n - 1);
    }

    /**
     * Using Segment Tree Approach
     *
     * TC: O(log(N))
     * SC: O(log(N))
     */
    private void updateSegmentTree(int segIdx, int index, int val, int left, int right) {
        // Base Case
        if (left == right) {
            segTree[segIdx] = val;
            return;
        }
        // Recursion Calls
        int mid = (left + right) / 2;
        if (index <= mid) {
            // recursively look at left sub-tree
            updateSegmentTree(2 * segIdx + 1, index, val, left, mid);
        } else {
            // recursively look at right sub-tree
            updateSegmentTree(2 * segIdx + 2, index, val, mid + 1, right);
        }
        segTree[segIdx] = segTree[2 * segIdx + 1] + segTree[2 * segIdx + 2];
    }
    
    /**
     * Using Segment Tree Approach
     *
     * TC: O(log(N))
     * SC: O(log(N))
     */
    public int sumRange(int left, int right) {
        return getRangeFromSegmentTree(0, 0, n - 1, left, right);
    }

    /**
     * Using Segment Tree Approach
     *
     * TC: O(log(N))
     * SC: O(log(N))
     */
    private int getRangeFromSegmentTree(int segIdx, int left, int right, int l, int r) {
        // case 1 - out of bounds check
        if (l > right || r < left) {
            return 0;
        }
        // case 2 - within the exact range
        if (l <= left && r >= right) {
            return segTree[segIdx];
        }
        // case 3 - when there is an overlap
        int mid = (left + right) / 2;
        return getRangeFromSegmentTree(2 * segIdx + 1, left, mid, l, r) + 
            getRangeFromSegmentTree(2 * segIdx + 2, mid + 1, right, l, r);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
