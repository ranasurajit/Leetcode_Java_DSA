class Solution {
    /**
     * TC: O(N + N x log(N)) ~ O(N x log(N))
     * SC: O(3 x N) ~ O(N)
     */
    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] marked = new boolean[n];          // SC: O(N)
        // min-heap with pair { number, index }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((int[] p, int[] q) -> {
            if (p[0] == q[0]) {
                return p[1] - q[1];
            } else {
                return p[0] - q[0];
            }
        });                                         // SC: O(2 x N)
        for (int i = 0; i < n; i++) {               // TC: O(N)
            pq.offer(new int[] { nums[i], i });     // TC: O(log(N))
        }
        long score = 0L;
        while (!pq.isEmpty()) {                     // TC: O(N)
            int[] current = pq.poll();
            int index = current[1];
            if (!marked[index]) {
                score += current[0];
                marked[index] = true;
                if (index + 1 < n) {
                    marked[index + 1] = true;
                }
                if (index - 1 >= 0) {
                    marked[index - 1] = true;
                }
            }
        }
        return score;
    }
}
