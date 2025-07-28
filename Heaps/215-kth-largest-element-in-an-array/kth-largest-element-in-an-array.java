class Solution {
    /**
     * Approach : Using PriorityQueue (Min-Heap) Approach
     *
     * TC: O(N x log(N))
     * SC: O(K)
     */
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        // we will insert elements to Min-Heap (PriorityQueue)
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); // SC: O(K)
        for (int i = 0; i < n; i++) {  // TC: O(N)
            if (pq.size() < k) {
                pq.offer(nums[i]);     // TC: O(log(N))
            } else {
                if (!pq.isEmpty() && nums[i] > pq.peek()) {
                    pq.poll();
                    pq.offer(nums[i]); // TC: O(log(N))
                }
            }
        }
        return pq.peek();
    }
}
