/**
 * Approach : Using Min Heap (PriorityQueues) Approach
 * TC: O(N x log(K)) + O(P x log(K))
 * SC: O(K)
 *
 * where P = total number of 'add' operations
 */
class KthLargest {
    PriorityQueue<Integer> pq = null;
    private int k;

    /**
     * TC: O(N x log(K))
     * SC: O(1)
     */
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>(); // SC: O(K)
        for (int num : nums) { // TC: O(N)
            pq.offer(num); // TC: O(log(K))
            if (pq.size() > k) {
                pq.poll();
            }
        }
    }
    
    /**
     * TC: O(log(K))
     * SC: O(1)
     */
    public int add(int val) {
        pq.offer(val); // TC: O(log(K))
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
