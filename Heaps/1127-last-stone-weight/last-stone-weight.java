class Solution {
    /**
     * Approach : Using Max Heaps (PriorityQueues) Approach
     *
     * TC: O(N x log(N)) + O(N x log(N)) ~ O(N x log(N))
     * SC: O(N)
     */
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        /**
         * To smash the heaviest two stones, we will be using a Max-Heap 
         * to store the stones[i] and poll two heaviest and offer the 
         * remaining result after smashing them
         */
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((p, q) -> q - p); // SC: O(N)
        for (int i = 0; i < n; i++) {     // TC: O(N)
            pq.offer(stones[i]);          // TC: O(log(N))
        }
        while (pq.size() > 1) {           // TC: O(N)
            // the loop should run till we have only one stone left
            int first = pq.poll();
            int second = pq.poll();
            if (first - second > 0) {
                pq.offer(first - second); // TC: O(log(N))
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
