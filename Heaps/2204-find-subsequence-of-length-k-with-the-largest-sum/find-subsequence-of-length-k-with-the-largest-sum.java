class Solution {
    /**
     * Approach : Using Heaps Approach
     *
     * TC: O(N x log(K)) + O(K) + O(K) ~ O(N x log(K))
     * SC: O(K) + O(K) ~ O(K)
     */
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        if (k == n) {
            return nums;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p, q) -> p[0] - q[0]); // SC: O(K)
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (pq.size() < k) {
                pq.offer(new int[] { nums[i], i }); // TC: O(log(K))
            } else {
                if (nums[i] > pq.peek()[0]) {
                    pq.poll();
                    pq.offer(new int[] { nums[i], i }); // TC: O(log(K))
                }
            }
        }
        PriorityQueue<int[]> pqSorted = new PriorityQueue<int[]>((p, q) -> p[1] - q[1]); // SC: O(K)
        while (!pq.isEmpty()) { // TC: O(K)
            pqSorted.offer(pq.poll());
        }
        int[] result = new int[k];
        int index = 0;
        while (!pqSorted.isEmpty()) { // TC: O(K)
            result[index++] = pqSorted.poll()[0];
        }
        return result;
    }
}
