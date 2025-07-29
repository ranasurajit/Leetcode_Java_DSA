/**
 * Approach : Using Min and Max Heaps (PriorityQueues) Approach
 *
 * TC: O(log(N)) per addNum operation
 * SC: O(N) for constructor call
 */
class MedianFinder {

    PriorityQueue<Integer> leftMaxHeap = null;
    PriorityQueue<Integer> rightMinHeap = null;

    /**
     * TC: O(1)
     * SC: O(N)
     */
    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<Integer>((p, q) -> q - p); // SC: O(N / 2)
        rightMinHeap = new PriorityQueue<Integer>();               // SC: O(N / 2)
    }
    
    /**
     * TC: O(log(N)) + O(log(N)) ~ O(log(N))
     * SC: O(1)
     */
    public void addNum(int num) {
        if (leftMaxHeap.isEmpty() || num < leftMaxHeap.peek()) {
            leftMaxHeap.offer(num); // TC: O(log(N))
        } else {
            rightMinHeap.offer(num); // TC: O(log(N))
        }
        /**
         * always balance between both leftMaxHeap and rightMinHeap such that
         * size(leftMaxHeap) == size(rightMinHeap) or size(leftMaxHeap) == size(rightMinHeap) + 1
         */
        if (leftMaxHeap.size() - rightMinHeap.size() > 1) {
            rightMinHeap.offer(leftMaxHeap.poll()); // TC: O(log(N))
        } else if (leftMaxHeap.size() < rightMinHeap.size()) {
            leftMaxHeap.offer(rightMinHeap.poll()); // TC: O(log(N))
        }
    }
    
    /**
     * TC: O(1)
     * SC: O(1)
     */
    public double findMedian() {
        int m = leftMaxHeap.size();
        int n = rightMinHeap.size();
        if (n == 0) {
            return (double) leftMaxHeap.peek();
        }
        if (((m + n) & 1) == 0) {
            // sum of both leftMaxHeap and rightMinHeap is even
            return (double) (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
        } else {
            return (double) leftMaxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
