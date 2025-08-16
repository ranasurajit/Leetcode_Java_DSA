class Solution {
    /**
     * Approach II : Using Math Approach (No Extra Space)
     *
     * TC: O(log10(N))
     * SC: O(1)
     */
    public int maximum69Number(int num) {
        int n = num;
        int position = 0;
        int maxPos = -1;
        while (n > 0) {
            int rem = n % 10;
            n = n / 10;
            if (rem == 6) {
                maxPos = Math.max(maxPos, position); 
            }
            position++;
        }
        if (maxPos == -1) {
            return num;
        }
        return num + (9 - 6) * (int) Math.pow(10, maxPos);
    }

    /**
     * Approach I : Using Math + String Simulation Approach (Extra Space)
     *
     * TC: O(log10(N))
     * SC: O(log10(N))
     */
    public int maximum69NumberUsingStringSimulation(int num) {
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
