class Solution {
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        reverse(ch, 0, n - 1);
        int i = 0;
        int left = 0;
        int right = 0;
        while (i < n) {
            while (i < n && ch[i] != ' ') {
                ch[right] = ch[i];
                i++;
                right++;
            }
            // at this point i points to a space
            // reverse string between left and right
            if (left < right) {
                // reverse
                reverse(ch, left, right - 1);
                if (right < n) {
                    ch[right] = ' ';
                }
                right++;
                left = right;
            }
            i++;
        }
        return String.valueOf(ch).substring(0, right - 1);
    }

    private void reverse(char[] ch, int p, int q) {
        while (p < q) {
            char temp = ch[q];
            ch[q] = ch[p];
            ch[p] = temp;
            p++;
            q--;
        }
    }
}
