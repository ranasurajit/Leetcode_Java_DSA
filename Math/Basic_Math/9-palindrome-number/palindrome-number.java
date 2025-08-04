class Solution {
    /**
     * Approach : Using Math Approach
     * 
     * TC: O(log(N) Base 10)
     * SC: O(1)
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = x;
        int rev = 0;
        int rem = 0;
        while (x > 0) { // TC: O(log(N) Base 10)
            rem = x % 10;
            rev = rev * 10 + rem;
            x = x / 10;
        }
        return num == rev;
    }
}
