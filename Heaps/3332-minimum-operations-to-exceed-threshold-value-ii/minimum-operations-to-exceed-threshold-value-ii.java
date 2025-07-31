class Solution {
    /**
     * Approach : Using Min-Heap (PriorityQueues) Approach
     *
     * TC: O(N x log(N)) + O(N x log(N)) ~ O(N x log(N))
     * SC: O(N)
     */
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        // we will be adding elements from array 'nums' in Min-Heap
        PriorityQueue<Long> pq = new PriorityQueue<Long>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            pq.offer((long) nums[i]); // TC: O(log(N))
        }
        int operations = 0;
        long x = 0L;
        long y = 0L;
        while (!pq.isEmpty() && pq.peek() < k) { // TC: O(N)
            if (pq.size() >= 2 && pq.peek() < k) {
                x = pq.poll();
                y = pq.poll();
                pq.offer((2 * x) + y); // // TC: O(log(N))
                operations++;
            } else {
                break;
            }
        }
        return operations;
    }
}
