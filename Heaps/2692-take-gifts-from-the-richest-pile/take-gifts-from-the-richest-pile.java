class Solution {
    /**
     * TC: O(2 x N + K) ~ O(N + K)
     * SC: O(N)
     */
    public long pickGifts(int[] gifts, int k) {
        int n = gifts.length;
        // Max-heap SC: O(N)
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((p, q) -> q - p);
        for (int i = 0; i < n; i++) { // TC: O(N)
            pq.offer(gifts[i]);
        }
        int count = 0;
        while (count < k) {           // TC: O(K)
            Integer current = pq.poll();
            pq.offer((int) Math.sqrt(current));
            count++;
        }
        long total = 0L;
        while (!pq.isEmpty()) {       // TC: O(N)
            total += (long) pq.poll();
        }
        return total;
    }
}
