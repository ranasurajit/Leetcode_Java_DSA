class Solution {
    /**
     * Using PriorityQueue
     * TC: O(Nlog(N) + Klog(N))
     * SC: O(N)
     */
    public long maxKelements(int[] nums, int k) {
        int n = nums.length;
        // storing in max-heap TC: O(Nlog(N)), SC: O(N)
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder()); 
        for (int it : nums) { // TC: O(N)
            pq.offer(it);
        }
        long score = 0L;
        while (!pq.isEmpty() && k > 0) { // TC: O(K)
            int top = pq.poll(); // TC: O(log(N))
            score += top;
            int deno = (int) Math.ceil(top / 3.0);
            pq.offer(deno); // TC: O(log(N))
            k--;
        }
        return score;
    }
}
