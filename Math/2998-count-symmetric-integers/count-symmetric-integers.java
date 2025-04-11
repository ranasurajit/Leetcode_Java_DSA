class Solution {
    /**
     * Approach II : Better Approach
     *
     * TC: O(H - L)
     * SC: O(1)
     * where L = average length of number
     *
     * Runtime: 31 ms Beats < 35%
     */
    public int countSymmetricIntegers(int low, int high) {
        int countSymmetric = 0;
        for (int i = low; i <= high; i++) { // TC: O(H - L)
            if (i >= 10 && i <= 99 && i % 11 == 0) { // digits of size 2
                countSymmetric++;
            } else if (i >= 1000 && i <= 9999) {
                int first = i / 1000;
                int second = (i / 100) % 10;
                int third = (i / 10) % 10;
                int fourth = i % 10;
                if (first + second == third + fourth) {
                    countSymmetric++;
                }
            }
        }
        return countSymmetric;
    }

    /**
     * Approach I : Brute-Force Approach
     *
     * TC: O(Len x (H - L))
     * SC: O(1)
     * where L = average length of number
     *
     * Runtime: 31 ms Beats < 35%
     */
    public int countSymmetricIntegersApproachI(int low, int high) {
        int countSymmetric = 0;
        for (int i = low; i <= high; i++) { // TC: O(H - L)
            String numVal = String.valueOf(i); // TC: O(Len)
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
