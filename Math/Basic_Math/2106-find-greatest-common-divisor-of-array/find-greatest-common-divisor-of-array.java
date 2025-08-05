class Solution {
    /**
     * Approach : Using Euler's Euclidean GCD Algorithm Approach
     * 
     * TC: O(N) + O(log(Min(nums)))
     * SC: O(log(Min(nums)))
     */
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int x : nums) { // TC: O(N)
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        return gcd(max, min); // TC: O(log(Min(a, b))), SC: O(log(Min(a, b)))
    }

    /**
     * Using Euler's Euclidean GCD Algorithm Approach
     * 
     * TC: O(log(Min(a, b)))
     * SC: O(log(Min(a, b)))
     */
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
