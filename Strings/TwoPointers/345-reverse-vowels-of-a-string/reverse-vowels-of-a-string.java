class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int p = 0;
        int q = ch.length - 1;
        while (p < q) {
            if (!isVowel(ch[p])) {
                p++;
            } else if (!isVowel(ch[q])) {
                q--;
            }
            if (isVowel(ch[p]) && isVowel(ch[q])) {
                char temp = ch[q];
                ch[q] = ch[p];
                ch[p] = temp;
                p++;
                q--;
            }
        }
        return new String(ch);
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' ||
            ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' ||
            ch == 'u' || ch == 'U';
    }
}
