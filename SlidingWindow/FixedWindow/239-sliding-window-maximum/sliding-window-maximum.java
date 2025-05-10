class Solution {
    /**
     * Approach : Using Sliding Window (Fixed Length) Approach
     *
     * TC: O(N)
     * SC: O(K)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int[] result = new int[n - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>(); // SC: O(K)
        int index = 0;
        while (j < n) { // TC: O(N)
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.pollLast();
            }
            deque.addLast(nums[j]);
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                result[index++] = deque.peekFirst();
                // remove calculation from index 'i'
                if (!deque.isEmpty() && deque.peekFirst() == nums[i]) {
                    deque.pollFirst();
                }
                // slide to next window
                i++;
                j++;
            }
        }
        return result;
    }
}
