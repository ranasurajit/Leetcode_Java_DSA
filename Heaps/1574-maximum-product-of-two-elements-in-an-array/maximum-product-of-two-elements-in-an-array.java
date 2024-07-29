class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((p, q) -> q - p);
        for (int i = 0; i < n; i++) {
            pq.offer(nums[i]);
        }
        int high1 = pq.poll();
        int high2 = pq.poll();
        return (high1 - 1) * (high2 - 1);
    }
}