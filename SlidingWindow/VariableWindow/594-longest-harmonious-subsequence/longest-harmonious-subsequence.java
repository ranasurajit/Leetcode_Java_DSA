class Solution {
    /**
     * Approach : Using Sorting + Sliding Window (Variable Size) Approach
     *
     * TC: O(N x log(N)) + O(N) ~ O(N x log(N))
     * SC: O(N)
     */
    public int findLHS(int[] nums) {
        int n = nums.length;
        // since we need the subsequence so re-ordering does not matter so we can sort the Array 'nums'
        Arrays.sort(nums); // TC: O(N x log(N))
        int i = 0;
        int j = 0;
        int maxLength = 0;
        // we will be storing indices in the ArrayDeque
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>(); // SC: O(N)
        while (j < n) { // TC: O(N)
            while (!deque.isEmpty() && Math.abs(nums[j] - nums[deque.peekFirst()]) > 1) {
                int index = deque.pollFirst();
                i = index + 1;
            }
            deque.addLast(j);
            if (nums[deque.peekLast()] - nums[deque.peekFirst()] == 1) {
                maxLength = Math.max(maxLength, j - deque.peekFirst() + 1);
            }
            j++;
        }
        return maxLength;
    }
}
