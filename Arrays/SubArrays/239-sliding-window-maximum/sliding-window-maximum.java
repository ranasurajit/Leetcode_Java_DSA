class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        int[] max = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if (i - k == deque.getFirst()) {
                deque.removeFirst();
            }
            if (i >= k - 1) {
                max[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return max;
    }
}
