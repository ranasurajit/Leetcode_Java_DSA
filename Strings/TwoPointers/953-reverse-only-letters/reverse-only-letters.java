class Solution {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        reverse(chars, 0, n - 1);
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            int startNum = chars[start];
            int endNum = chars[end];
            if (!isAlphabet(startNum)) {
                start++;
            }
            if (!isAlphabet(endNum)) {
                end--;
            }
            if (isAlphabet(startNum) && isAlphabet(endNum)) {
                char temp = chars[end];
                chars[end] = chars[start];
                chars[start] = temp;
                start++;
                end--;
            }
        }
    }

    private boolean isAlphabet(int ascii) {
        return (ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122);
    }
}
