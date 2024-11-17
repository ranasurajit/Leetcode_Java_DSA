class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        ArrayDeque<Pair> deque = new ArrayDeque<Pair>(); // SC: O(N)
        long currentSum = 0L;
        int minLength = Integer.MAX_VALUE;
        for (int i= 0; i < n; i++) { // TC: O(N)
            currentSum += nums[i];
            if (currentSum >= k) {
                minLength = Math.min(minLength, i + 1);
            }
            // shrinking the sliding window from beginning index i to meet the condition
            while (!deque.isEmpty() && currentSum - deque.peekFirst().sum >= k) {
                minLength = Math.min(minLength, i - deque.pollFirst().index);
            }
            // the below code is to make the deque monotonically increasing
            while (!deque.isEmpty() && currentSum <= deque.peekLast().sum) {
                deque.pollLast();
            }
            deque.addLast(new Pair(i, currentSum));
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    class Pair {
        int index;
        long sum;
        public Pair (int index, long sum) {
            this.index = index;
            this.sum = sum;
        }
    }
}
