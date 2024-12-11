class Solution {
    /**
     * TC: O(N x log(N))
     */
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> intervals = 
            new PriorityQueue<int[]>((int[] p, int[] q) -> {
            return p[0] - q[0];
        });                                                          // SC: O(N)
        for (int i = 0; i < n; i++) {                                // TC: O(N)
            intervals.offer(new int[] { nums[i] - k, nums[i] + k }); // TC: O(log(N))
        }
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();       // SC: O(N)
        int beautyCount = 0;
        while (!intervals.isEmpty()) {                               // TC: O(N)
            int[] current = intervals.poll();
            while (!deque.isEmpty() && deque.peekFirst() < current[0]) {
                deque.pollFirst();
            }
            deque.offerLast(current[1]);
            beautyCount = Math.max(beautyCount, deque.size());
        }
        return beautyCount;
    }
}
