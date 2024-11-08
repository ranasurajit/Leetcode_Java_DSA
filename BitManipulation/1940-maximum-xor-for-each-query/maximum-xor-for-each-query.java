class Solution {
    /**
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int xor = 0;
        for (int it : nums) {                    // TC: O(N)
            xor = xor ^ it;
        }
        int mask = (1 << maximumBit) - 1;
        int[] answer = new int[n];
        for (int i = n - 1; i >= 0; i--) {       // TC: O(N)
            answer[n - i - 1] = mask ^ xor;
            xor = xor ^ nums[i];
        }
        return answer;
    }
}
