class KthLargest {

    PriorityQueue<Integer> pq;
    int k;
    int kthElement;

    public KthLargest(int k, int[] nums) {
        // we will maintain only k elements in the p\PriorityQueue
        this.pq = new PriorityQueue<Integer>();
        this.k = k;
        for (int it : nums) {
            pq.offer(it);
        }
    }
    
    public int add(int val) {
        if (this.pq.size() < k || val > this.pq.peek()) {
            // add the val to the Priority Queue
            this.pq.offer(val);
            // remove extra elements from PriorityQueue if greater than k
            while (this.pq.size() > k) {
                this.pq.poll();
            }
        }
        return this.pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
