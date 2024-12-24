class Solution {
    /**
     * Took two pointers i and j = 0 and increment j till window size of 'k' is
     * reached
     * 
     * add index j to a Deque (as we can add and remove from both ends of it)
     * remove all elements from beginning of a deque < arr[j]
     * 
     * Note: we will be storing indices in Deque
     * 
     * Window size: (j - i + 1)
     * 
     * when window size < k, then keep increasing j
     * when window size = k,
     * 1. add 1st element from beginning of deque to the resultant array/list
     * 2. remove 1st element from beginning of deque if it = i
     * 
     * maintain the sliding window size of k, by incrementing both i an j
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int n = nums.length;
        int i = 0; // pointer for start of sliding window
        int j = 0; // pointer for end of sliding window
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>(); // O(N)
        while (j < n) { // TC: O(N)
            if (deque.isEmpty()) {
                deque.addLast(j);
            } else {
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[j]) {
                    deque.pollLast();
                }
                deque.addLast(j);
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                result.add(nums[deque.peekFirst()]);
                if (i == deque.peekFirst()) {
                    deque.pollFirst();
                }
                // slide the window
                i++;
                j++;
            }
        }
        int[] max = new int[n - k + 1];
        for (i = 0; i < n - k + 1; i++) {
            max[i] = result.get(i);
        }
        return max;
    }
}
