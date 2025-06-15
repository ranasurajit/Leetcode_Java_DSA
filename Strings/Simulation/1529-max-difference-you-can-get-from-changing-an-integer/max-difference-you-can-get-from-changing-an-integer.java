class Solution {
    /**
     * Approach : Using String and Simulation Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public int maxDiff(int num) {
        char[] digitCharsMax = String.valueOf(num).toCharArray(); // SC: O(N)
        char[] digitCharsMin = digitCharsMax.clone(); // SC: O(N)
        int n = digitCharsMax.length;
        char x1 = 0;
        char x2 = 0;
        int minIndex = -1;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (x1 == 0 && digitCharsMax[i] != '9') {
                x1 = digitCharsMax[i];
            }
            if (x2 == 0 && digitCharsMax[i] != '1') {
                if (digitCharsMax[i] == '0') {
                    continue;
                }
                x2 = digitCharsMax[i];
                minIndex = i;
            }
        }
        // replace all occurences of x1 with '9' and x2 with '0' or '1' ('0' if minIndex > 0)
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (digitCharsMax[i] == x1) {
                digitCharsMax[i] = '9';
            }
            if (digitCharsMin[i] == x2) {
                digitCharsMin[i] = minIndex > 0 ? '0' : '1';
            }
        }
        return Integer.valueOf(String.valueOf(digitCharsMax)) - 
            Integer.valueOf(String.valueOf(digitCharsMin));
    }
}
