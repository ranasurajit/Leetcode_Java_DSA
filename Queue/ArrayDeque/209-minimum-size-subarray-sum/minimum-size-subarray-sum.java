class Solution {
    /**
     * Using Deque
     *
     * TC: O(N)
     * SC: O(N)
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        ArrayDeque<Pair> deque = new ArrayDeque<Pair>(); // SC: O(N)
        int minLength = Integer.MAX_VALUE;
        long currentSum = 0L;
        for (int i = 0; i < n; i++) { // TC: O(N)
            currentSum += nums[i];
            if (currentSum >= target) {
                minLength = Math.min(minLength, i + 1);
            }
            // shrink the window
            while (!deque.isEmpty() && currentSum - deque.peekFirst().sum >= target) {
                minLength = Math.min(minLength, i - deque.pollFirst().index);
            }
            deque.addLast(new Pair(i, currentSum));
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    class Pair {
        int index;
        long sum;
        public Pair (int index, long sum) {
            this.index = index;
            this.sum = sum;
        }
    }

    /**
     * Using Two Pointers
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int minSubArrayLenTwoPointers(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        long currentSum = 0L;
        for (int i = 0, j = 0; j < n; j++) { // TC: O(N)
            currentSum += nums[j];
            if (currentSum >= target) {
                minLength = Math.min(minLength, j - i + 1);
            }
            // shrink the window
            while (currentSum - nums[i] >= target) {
                currentSum -= nums[i];
                i++;
                minLength = Math.min(minLength, j - i + 1);
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
