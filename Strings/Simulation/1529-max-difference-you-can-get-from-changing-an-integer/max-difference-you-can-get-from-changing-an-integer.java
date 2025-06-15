class Solution {
    /**
     * Approach II : Using StringBuilder and Simulation Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(3 x N) ~ O(N)
     */
    public int maxDiff(int num) {
        char[] digitChars = String.valueOf(num).toCharArray(); // SC: O(N)
        int n = digitChars.length;
        char x1 = 0;
        char x2 = 0;
        int minIndex = -1;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (x1 == 0 && digitChars[i] != '9') {
                x1 = digitChars[i];
            }
            if (x2 == 0 && digitChars[i] != '1') {
                if (digitChars[i] == '0') {
                    continue;
                }
                x2 = digitChars[i];
                minIndex = i;
            }
        }
        // replace all occurences of x1 with '9' and x2 with '0' or '1' ('0' if minIndex > 0)
        StringBuilder maxSb = new StringBuilder(); // SC: O(N)
        StringBuilder minSb = new StringBuilder(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (digitChars[i] == x1) {
                maxSb.append('9');
            } else {
                maxSb.append(digitChars[i]);
            }
            if (digitChars[i] == x2) {
                if (minIndex > 0) {
                    minSb.append('0');
                } else {
                    minSb.append('1');
                }
            } else {
                minSb.append(digitChars[i]);
            }
        }
        return Integer.valueOf(maxSb.toString()) - Integer.valueOf(minSb.toString());
    }

    /**
     * Approach I : Using String and Simulation Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public int maxDiffApproachI(int num) {
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
