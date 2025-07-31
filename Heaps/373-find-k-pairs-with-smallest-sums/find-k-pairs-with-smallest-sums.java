class Solution {
    /**
     * Approach : Using Brute-Force with Max Heap (PriorityQueues) Approach
     *
     * TC: O(M x N x log(K)) + O(K) ~ O(M x N x log(K))
     * SC: O(K)
     *
     * Accepted (31 / 31 testcases passed)
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p, q) -> q[2] - p[2]); // SC: O(K)
        for (int i = 0; i < m; i++) { // TC: O(M)
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (pq.size() < k) {
                    pq.offer(new int[] { nums1[i], nums2[j], nums1[i] + nums2[j] }); // TC: O(log(K))
                } else if (nums1[i] + nums2[j] < pq.peek()[2]) {
                    pq.poll();
                    pq.offer(new int[] { nums1[i], nums2[j], nums1[i] + nums2[j] }); // TC: O(log(K))
                } else {
                    // nums1[i] + nums2[j] >= pq.peek()[2] so break the loop
                    break;
                }
            }
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while (!pq.isEmpty()) { // TC: O(K)
            List<Integer> list = new ArrayList<Integer>();
            int[] current = pq.poll();
            list.add(current[0]);
            list.add(current[1]);
            result.add(list);
        }
        return result;
    }
}
