class Solution {
    /**
     * Using Two Pointers
     *
     * TC: O(N)
     * SC: O(N)
     */
    public String reverseWords(String s) {
        char[] chars = s.toCharArray(); // SC: O(N)
        int n = chars.length;
        // reverse the entire String
        reverse(chars, 0, n - 1); // TC: O(N)
        int i = 0;
        int left = 0;
        int right = 0;
        while (i < n) { // TC: O(2 x N)
            while (i < n && chars[i] != ' ') {
                chars[right] = chars[i];
                right++;
                i++;
            }
            // reverse the word between left and right
            if (left < right) {
                reverse(chars, left, right - 1);
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
     * TC: O(end - start)
     * SC: O(1)
     */
    private String reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(chars);
    }

    /**
     * Using Stack
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public String reverseWordsUsingStack(String s) {
        String[] words = s.split(" ");
        Stack<String> st = new Stack<String>(); // SC: O(N)
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        for (String word : words) { // TC: O(N)
            if (word != "") {
                st.push(word);
            }
        }
        while (!st.isEmpty()) { // TC: O(N)
            sb.append(st.pop() + " ");
        }
        return String.valueOf(sb).trim();
    }
}
