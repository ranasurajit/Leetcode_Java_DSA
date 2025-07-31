class Solution {
    /**
     * Approach : Using Max-Heap (PriorityQueues) Approach
     *
     * TC: O(N x log(N)) + O(K x log(N)) ~ O((N + K) x log(N))
     * SC: O(N)
     */
    public long maxKelements(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            pq.offer(nums[i]);        // TC: O(log(N))
        }
        long score = 0L;
        while (!pq.isEmpty() && k > 0) { // TC: O(K)
            long current = (long) pq.poll();
            score += current;
            pq.offer((int) Math.ceil(current / 3.0)); // TC: O(log(N))
            k--;
        }
        return score;
    }
}
