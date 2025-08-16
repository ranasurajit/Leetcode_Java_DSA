class Solution {
    /**
     * Approach : Using Math + String Simulation Approach
     *
     * TC: O(log10(N))
     * SC: O(log10(N))
     */
    public int maximum69Number (int num) {
        char[] digits = String.valueOf(num).toCharArray(); // SC: O(log10(N))
        for (int i = 0; i < digits.length; i++) { // TC: O(log10(N))
            if (digits[i] == '6') {
                digits[i] = '9';
                // at most one digit can be changed
                break;
            }
        }
        return Integer.valueOf(String.valueOf(digits));
    }
}
