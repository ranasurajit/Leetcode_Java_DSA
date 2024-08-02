class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int windowSize = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                windowSize++;
            }
        }
        int current1s = 0;
        int max1s = 0;
        for (int i = 0; i < windowSize; i++) {
            if (nums[i] == 1) {
                current1s++;
            }
        }
        /**
         * using modulo to prevent any additional array size and making 
         * it circular so i = i % n when i > n
         */
        for (int i = windowSize; i < 2 * n; i++) {
            if (nums[(i - windowSize) % n] == 1) {
                current1s--;
            }
            if (nums[i % n] == 1) {
                current1s++;
            }
            max1s = Math.max(max1s, current1s);
        }
        return windowSize - max1s;
    }
}
