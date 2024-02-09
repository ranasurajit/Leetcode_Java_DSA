class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        int[] result = new int[n + 1];
        result[0] = 1;

        for (int i = 1; i < result.length; i++) {
            result[i] = digits[i - 1];
        }
        return result;
    }
}