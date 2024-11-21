class Solution {
    /**
     * TC: O(N / 2) ~ O(N)
     * SC: O(1)
     */
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int start = 0;
        int end = n - 1;
        while (start < end) { // TC: O(N / 2)
            if (!isVowel(chars[start])) {
                start++;
            } else if (!isVowel(chars[end])) {
                end--;
            } else {
                // both characters at indices 'start' and 'end' are vowels so swap
                char temp = chars[end];
                chars[end] = chars[start];
                chars[start] = temp;
                start++;
                end--;
            }
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
