class Solution {
    /**
     * Approach : Using Simulation + Euclid's GCD Approach
     *
     * TC: O(N) + O(log(Min(nums)))
     * SC: O(log(Min(nums)))
     */
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) { // TC: O(N)
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return gcd(max, min); // TC: O(log(Min(nums))), SC: O(log(Min(nums)))
    }

    /**
     * Using Euclid's GCD Approach
     *
     * TC: O(log(Min(a, b)))
     * SC: O(log(Min(a, b)))
     */
    private int gcd(int a, int b) {
        if (b > a) {
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
