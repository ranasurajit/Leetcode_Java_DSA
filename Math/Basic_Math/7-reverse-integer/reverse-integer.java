class Solution {
    /**
     * Approach : Using Math Approach
     * 
     * TC: O(log(N) Base 10)
     * SC: O(1)
     */
    public int reverse(int x) {
        long rev = 0L;
        int rem = 0;
        int neg = x < 0 ? -1 : 1;
        x = x * neg;
        while (x > 0) {  // TC: O(log(N) Base 10)
            rem = x % 10;
            rev = rev * 10 + rem;
            x = x / 10;
        }
        if (rev > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) rev * neg;
    }
}
