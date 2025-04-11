class Solution {
    /**
     * Approach I : Brute-Force Approach
     *
     * TC: O(Len x (H - L))
     * SC: O(1)
     * where L = average length of number
     */
    public int countSymmetricIntegers(int low, int high) {
        int countSymmetric = 0;
        for (int i = low; i <= high; i++) { // TC: O(H - L)
            String numVal = String.valueOf(i);
            int len = numVal.length();
            if (isSymmetric(numVal)) { // TC: O(Len)
                countSymmetric++;
            }
        }
        return countSymmetric;
    }

    /**
     * Validate if number is symmetric
     *
     * TC: O(Len)
     * SC: O(1)
     * where Len = average length of number
     */
    private boolean isSymmetric(String numVal) {
        int len = numVal.length();
        if (len % 2 != 0) {
            return false;
        }
        int sum = 0;
        int halfSum = 0;
        for (int i = 0; i < len; i++) { // TC: O(L)
            sum += numVal.charAt(i) - '0';
            if (i < len / 2) {
                halfSum += numVal.charAt(i) - '0';
            }
        }
        return halfSum * 2 == sum;
    }
}
