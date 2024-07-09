class KthLargest {

    // Kth Largest asked so create Min Heap PriorityQueue
    private PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int it : nums) {
            pq.add(it);
        }
        while (pq.size() > k) {
            pq.remove();
        }
    }
    
    public int add(int val) {
        if (this.pq.size() < this.k) {
            pq.add(val);
        } else {
            if (val > pq.peek()) {
                pq.remove();
                pq.add(val);
            }
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
