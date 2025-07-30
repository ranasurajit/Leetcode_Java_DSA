class Solution {
    /**
     * Approach : Using Min Heap (PriorityQueues) + Hashing Approach
     *
     * TC: O(N) + O(N x log(K)) + O(K) ~ O(N + K + N x log(K))
     * SC: O(N) + O(K) ~ O(N + K)
     */
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }
        /**
         * we will be inserting values from HashMap to Min-Heap to 
         * order based upon frequency and will store only k elements
         * only
         */
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p, q) -> p[1] - q[1]); // SC: O(K)
        for (Integer key : freqMap.keySet()) { // TC: O(N)
            if (pq.size() < k) {
                pq.offer(new int[] { key, freqMap.get(key) });     // TC: O(log(K))
            } else {
                if (freqMap.get(key) > pq.peek()[1]) {
                    pq.poll();
                    pq.offer(new int[] { key, freqMap.get(key) }); // TC: O(log(K))
                }
            }
        }
        int index = k - 1;
        int[] topKArr = new int[k];
        while (!pq.isEmpty()) { // TC: O(K)
            topKArr[index--] = pq.poll()[0];
        }
        return topKArr;
    }
}
