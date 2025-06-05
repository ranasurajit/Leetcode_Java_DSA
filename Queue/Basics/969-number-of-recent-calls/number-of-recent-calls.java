/**
 * Approach : Using Queue Approach
 *
 * TC: O(1)
 * SC: O(N)
 */
class RecentCounter {
    Queue<Integer> queue = null;

    /**
     * TC: O(1)
     * SC: O(N)
     */
    public RecentCounter() {
        queue = new LinkedList<Integer>(); // SC: O(N)
    }
    
    /**
     * TC: O(1)
     * SC: O(1)
     */
    public int ping(int t) {
        queue.offer(t);
        int start = t - 3000;
        int end = t;
        while (queue.peek() < t - 3000) {
            /**
             * we poll it as we don't need it again as it is 
             * guaranteed that every call to ping uses a strictly 
             *larger value of t than the previous call
             */
            queue.poll();
        }
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
