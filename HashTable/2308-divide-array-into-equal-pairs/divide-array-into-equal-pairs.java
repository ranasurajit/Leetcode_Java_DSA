class Solution {
    /**
     * Approach I : Using HashMap Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer key : freq.keySet()) {
            if (freq.get(key) % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}

// int[] freq = new int[1001]; // SC: O(1001) (as per constraints 1 <= n <= 500)