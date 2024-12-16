class Solution {
    /**
     * TC: O(N x log(N) + K x log(N) + N) ~ O(N x log(N)) as where 1 <= K <= 10
     * SC: O(N)
     */
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        // min-heap to store <value, index>
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p, q) -> {
            if (p[0] == q[0]) {
                // values are same then return one with least index
                return p[1] - q[1];
            } else {
                return p[0] - q[0];
            }
        });                                     // SC: O(N)
        // adding values to PriorityQueue (min-heap) with <value, index>
        for (int i = 0; i < n; i++) {           // TC: O(N)
            pq.offer(new int[] { nums[i], i }); // TC: O(log(N))
        }
        // performing k operations
        while (k-- > 0) {                       // TC: O(K), where 1 <= K <= 10
            int[] current = pq.poll();
                                                // TC: O(log(N))
            pq.offer(new int[] { current[0] * multiplier, current[1] });
        }
        int[] result = new int[n];
        while (!pq.isEmpty()) {                 // TC: O(N)
            int[] current = pq.poll();
            result[current[1]] = current[0];
        }
        return result;
    }
}
