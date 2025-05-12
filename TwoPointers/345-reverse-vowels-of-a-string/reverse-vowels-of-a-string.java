class Solution {
    /**
     * Approach : Two Pointers Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int p = 0;
        int q = n - 1;
        while (p < q) { // TC: O(N)
            while (p < n && !isVowel(chars[p])) {
                p++;
            }
            while (q > 0 && !isVowel(chars[q])) {
                q--;
            }
            // at this point both the pointers, point to vowels
            // swap
            if (p < q) {
                char temp = chars[q];
                chars[q] = chars[p];
                chars[p] = temp;
            }
            p++;
            q--;
        }
        return String.valueOf(chars);
    }

    /**
     * TC: O(1)
     * SC: O(1)
     */
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
            ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
