class Solution {
    /**
     * Approach : Using Sliding Window (Fixed Size) + Deque Approach
     *
     * TC: O(N)
     * SC: O(K)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        /**
         * we will be storing indices of nums in Deque so 
         * that at the front of Deque we always have maximum
         * value of the window range
         */
        Deque<Integer> deque = new ArrayDeque<Integer>(); // SC: O(K)
        int i = 0; // start pointer of sliding window
        int j = 0; // end pointer of sliding window
        int[] answer = new int[n - k + 1];
        int index = 0;
        while (j < n) { // TC: O(N)
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[j]) {
                deque.pollLast();
            }
            deque.addLast(j);
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                answer[index++] = nums[deque.peekFirst()];
                // now we need to move to next window removing computation from index 'i'
                if (deque.peekFirst() == i) {
                    deque.pollFirst();
                }
                i++;
                j++;
            }
        }
        return answer;
    }
}
