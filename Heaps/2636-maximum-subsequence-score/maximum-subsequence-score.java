class Solution {
    /**
     * Approach : Using Min Heap (PriorityQueues) Approach
     *
     * TC: O(N) + O(N x log(N)) + O(N x log(K)) ~ O(N x (log(N) + log(K)))
     * SC: O(2 x N) + O(K) ~ O(N + K)
     */
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2]; // SC: O(2 x N)
        for (int i = 0; i < n; i++) {  // TC: O(N)
            pairs[i] = new int[] { nums1[i], nums2[i] };
        }
        /**
         * We will sort the pairs in descending order of nums2
         * as we need to take Min(nums2) for our calculation
         * to ensure we get the maximum value in Min(nums2) for 
         * k largest pairs
         */
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]); // TC: O(N x log(N))
        /**
         * We need a Min-Heap (PriorityQueue) to store k largest elements
         * from nums1
         */
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); // SC: O(K)
        long sum = 0L;
        long maxScore = 0L;
        for (int i = 0; i < n; i++) {  // TC: O(N)
            int num1 = pairs[i][0];
            int num2 = pairs[i][1];
            sum += num1;
            pq.offer(num1);            // TC: O(log(K))
            if (pq.size() > k) {
                sum -= pq.poll();
            }
            if (pq.size() == k) {
                maxScore = Math.max(maxScore, (long) num2 * sum);
            }
        }
        return maxScore;
    }
}
