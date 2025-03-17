class Solution {
    /**
     * Approach III : Using Bit-Manipulation Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        int xor1 = 0;
        int xor2 = 0;
        /**
         * In xor1 we do XOR operation for nums[i] + 1
         * to track edge cases where number appears odd
         * number of times and do not cancel out
         *
         * In xor2 we do XOR operation for nums[i] and 
         * as pairs needs to be of equal values so XOR
         * operation would cancel out to zero
         */
        for (int i = 0; i < n; i++) { // TC: O(N)
            xor1 = xor1 ^ (nums[i] + 1);
            xor2 = xor2 ^ nums[i];
        }
        return xor1 == 0 && xor2 == 0;
    }

    /**
     * Approach II : Using Constant Space Array Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public boolean divideArrayApproachII(int[] nums) {
        int n = nums.length;
        int[] freq = new int[1001]; // SC: O(1001) ~ O(1) (as per constraints 1 <= n <= 500)
        for (int i = 0; i < n; i++) { // TC: O(N)
            freq[nums[i]]++;
        }
        for (int i = 0; i < 1001; i++) { // TC: O(1001) ~ O(1)
            if (freq[i] % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Approach I : Using HashMap Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public boolean divideArrayApproachI(int[] nums) {
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
