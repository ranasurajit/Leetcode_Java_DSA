class Solution {
    /**
     * Using Greedy Approach - Min-Heap (PriorityQueue)
     *
     * TC: O(4 x N x log(N)) ~ O(N x log(N))
     * SC: O(N)
     */
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }
        // min-heap needed to sort the elements during insertion
        PriorityQueue<Long> pq = new PriorityQueue<Long>(); // SC: O(N)
        for (int i = 0; i < n; i++) {              // TC: O(N)
            pq.offer((long) nums[i]);
        }
        int operations = 0;
        while (pq.size() >= 2 && pq.peek() < k) {  // TC: O(N)
            long x = pq.poll();                    // TC: O(log(N))
            long y = pq.poll();                    // TC: O(log(N))
            pq.offer(x * 2 + y);                   // TC: O(log(N))
            operations++;
        }
        return operations;
    }
}
