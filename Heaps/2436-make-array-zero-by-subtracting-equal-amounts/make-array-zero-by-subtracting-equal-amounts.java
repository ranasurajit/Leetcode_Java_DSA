class Solution {
    /**
     * Approach I : Using Min Heaps (PriorityQueues) Approach
     *
     * TC: O(N x log(N)) + O(N x N x log(N)) ~ O((N ^ 2 x log(N))
     * SC: O(N)
     */
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) {     // TC: O(N)
            if (nums[i] > 0) {
                pq.offer(nums[i]);        // TC: O(log(N))
            }
        }
        int count = 0;
        while (!pq.isEmpty()) {           // TC: O(N)
            int x = pq.poll();
            pq.clear();
            count++;
            for (int i = 0; i < n; i++) { // TC: O(N)
                nums[i] -= x;
                if (nums[i] > 0) {
                    pq.offer(nums[i]);    // TC: O(log(N))
                }
            }
        }
        return count;
    }
}
