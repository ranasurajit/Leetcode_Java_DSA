class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((p, q) -> q - p);
        for (int i = 0; i < n; i++) {
            pq.offer(stones[i]);
        }
        while (pq.size() > 1) {
            Integer high = pq.poll();
            Integer low = pq.poll();
            if (high - low > 0) {
                pq.offer(high - low);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
