class Solution {
    /**
     * Approach : Using Binary Search on Answers Approach
     * 
     * TC: O(N + N x log(Max(nums) - Min(nums))) ~ O(N x log(Max(nums) - Min(nums)))
     * SC: O(1)
     * 
     * @param nums
     * @param threshold
     * @return
     */
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        long low = 1L;
        long high = 1L;
        for (int num : nums) { // TC: O(N)
            high = Math.max(high, num);
        }
        // Applying Binary Search
        long minDivisor = high;
        while (low <= high) { // TC: O(log(Max(nums) - Min(nums)))
            long mid = low + (high - low) / 2;
            if (getSumDivision(nums, mid) <= threshold) { // TC: O(N)
                minDivisor = Math.min(minDivisor, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) minDivisor;
    }

    /**
     * Using Simulation Approach
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * @param nums
     * @param div
     * @return
     */
    private long getSumDivision(int[] nums, long div) {
        long sum = 0;
        for (int num : nums) { // TC: O(N)
            sum += (num % div) == 0 ? num / div : (num / div) + 1;
        }
        return sum;
    }
}
