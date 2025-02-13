class Solution {
    /**
     * Using Greedy Approach - Min-Heap (PriorityQueue)
     *
     * TC: O(4 x N x log(N)) ~ O(N x log(N))
     * SC: O(N)
     */
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int operations = 0;
        // min-heap needed to sort the elements during insertion
        PriorityQueue<Long> pq = new PriorityQueue<Long>(); // SC: O(N)
        for (int i = 0; i < n; i++) {              // TC: O(N)
            pq.offer((long) nums[i]);
        }
        long x = 0L;
        long y = 0L;
        while (pq.peek() < k) {                    // TC: O(N)
            x = pq.poll();                         // TC: O(log(N))
            // check if PriorityQueue becomes empty after polling
            if (!pq.isEmpty()) {
                y = pq.poll();                     // TC: O(log(N))
                pq.offer(x * 2 + y);               // TC: O(log(N))
                operations++;
            } else {
                // the PriorityQueue had only 1 element
                break;
            }
        }
        return operations;
    }
}
