class RecentCounter {

    private Queue<Integer> callQueue;

    public RecentCounter() {
        callQueue = new LinkedList<Integer>();
    }
    
    public int ping(int t) {
        callQueue.offer(t);
        while (callQueue.peek() < t - 3000) {
            callQueue.poll();
        }
        return callQueue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
 