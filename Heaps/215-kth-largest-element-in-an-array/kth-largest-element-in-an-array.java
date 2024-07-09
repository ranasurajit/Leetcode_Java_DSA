class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            /*
             * add in the priority queue if nums[i] > peek value 
             * to ensure l elements are the largest in PriorityQueue
             */
            if (nums[i] > pq.peek()) {
                pq.remove();
                pq.add(nums[i]);
            }
        }
        // the peek/removed value will be the kth largest element
        return pq.remove();
    }
}
