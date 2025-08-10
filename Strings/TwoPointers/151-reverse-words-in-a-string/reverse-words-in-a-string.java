class Solution {
    /**
     * Approach : Using Two Pointers Approach
     *
     * TC: O(N) + O(N) ~ O(N)
     * SC: O(N)
     */
    public String reverseWords(String s) {
        int n = s.length();
        char[] chars = s.toCharArray(); // SC: O(N)
        reverse(chars, 0, n - 1); // TC: O(N)
        int i = 0; // pointer to iterate over char[] chars
        // Using Two Pointers
        int left = 0;
        int right = 0;
        while (i < n) { // TC: O(M)
            while (i < n && chars[i] != ' ') {
                chars[right++] = chars[i++];
            }
            if (left < right) {
                reverse(chars, left, right - 1); // TC: O(R - L)
                if (right < n) {
                    chars[right] = ' ';
                }
                right++;
                left = right;
            }
            i++;
        }
        return String.valueOf(chars).substring(0, right - 1);
    }

    /**
     * Using Two Pointers Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    private void reverse(char[] chars, int p, int q) {
        while (p < q) {
            char temp = chars[q];
            chars[q] = chars[p];
            chars[p] = temp;
            p++;
            q--;
        }
    }
}
