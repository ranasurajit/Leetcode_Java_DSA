class Solution {
    /**
     * Approach II : Using Hashing Approach
     *
     * TC: O(N) + O(N) ~ O(N)
     * SC: O(N)
     */
    public int findLHS(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        int maxLength = 0;
        for (Integer key : freq.keySet()) { // TC: O(N)
            if (freq.containsKey(key + 1)) {
                int currentLength = freq.get(key) + freq.get(key + 1);
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }

    /**
     * Approach I : Using Sorting + Sliding Window (Variable Size) Approach
     *
     * TC: O(N x log(N)) + O(N) ~ O(N x log(N))
     * SC: O(N)
     */
    public int findLHSUsingSlidingWindow(int[] nums) {
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
