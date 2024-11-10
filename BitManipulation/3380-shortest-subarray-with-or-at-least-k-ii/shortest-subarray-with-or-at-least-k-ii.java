class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int[] bits = new int[32];                                // SC: O(32)
        int minLength = Integer.MAX_VALUE;
        for (int i = 0, j = 0; j < n; j++) {                     // TC: O(N)
            addNumBits(nums[j], bits);                           // TC: O(32)
            while (currentSubArrayOR(bits) >= k && j >= i) {     // TC: O(32)
                minLength = Math.min(minLength, j - i + 1);
                removeNumBits(nums[i], bits);
                i++;
            }
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    /**
     * TC: O(32)
     * SC: O(1)
     */
    private void addNumBits(int num, int[] bits) {
        int i = 0;
        while (num > 0) {
            bits[i] += num & 1;
            num = num >> 1;
            i++;
        }
    }

    /**
     * TC: O(32)
     * SC: O(1)
     */
    private void removeNumBits(int num, int[] bits) {
        int i = 0;
        while (num > 0) {
            bits[i] -= num & 1;
            num = num >> 1;
            i++;
        }
    }

    /**
     * TC: O(32)
     * SC: O(1)
     */
    private int currentSubArrayOR(int[] bits) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            // sum += (int) (bits[i] * Math.pow(2, i));
            if (bits[i] > 0) {
                sum += (1 << i);
            }
        }
        return sum;
    }
}
