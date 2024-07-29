class Solution {
    /**
     * Using Iteration
     * TC: O(N)
     * SC: O(1)
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (max <= nums[i]) {
                max2 = max;
                max = nums[i];
            } else if (nums[i] > max2 && nums[i] != max) {
                max2 = nums[i];
            }
        }
        return (max - 1) * (max2 - 1);
    }

    /**
     * Using Priority Queue
     * TC: O(Nlog(N))
     * SC: O(N)
     */
    // public int maxProduct(int[] nums) {
    //     int n = nums.length;
    //     PriorityQueue<Integer> pq = new PriorityQueue<Integer>((p, q) -> q - p);
    //     for (int i = 0; i < n; i++) {
    //         pq.offer(nums[i]);
    //     }
    //     int high1 = pq.poll();
    //     int high2 = pq.poll();
    //     return (high1 - 1) * (high2 - 1);
    // }
}
