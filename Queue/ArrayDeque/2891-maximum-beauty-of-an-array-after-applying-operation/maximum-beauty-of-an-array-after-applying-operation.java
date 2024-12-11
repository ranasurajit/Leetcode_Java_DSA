class Solution {
    /**
     * Intervals Approach
     *
     * TC: O(N x log(N))
     * SC: O(N)
     */
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        List<int[]> intervals = new ArrayList<int[]>();            // SC: O(N)
        for (int i = 0; i < n; i++) {                              // TC: O(N)
            intervals.add(new int[] { nums[i] - k, nums[i] + k });
        }
        intervals.sort((a, b) -> a[0] - b[0]);                     // TC: O(N x log(N))
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();     // SC: O(N)
        int beautyCount = 0;
        for (int[] interval : intervals) {                           // TC: O(N)
            while (!deque.isEmpty() && deque.peekFirst() < interval[0]) {
                deque.pollFirst();
            }
            deque.offerLast(interval[1]);
            beautyCount = Math.max(beautyCount, deque.size());
        }
        return beautyCount;
    }
}
