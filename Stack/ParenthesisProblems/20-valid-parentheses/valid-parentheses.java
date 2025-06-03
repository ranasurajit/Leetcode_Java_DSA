class Solution {
    /**
     * Approach : Using Stack Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<Character>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            char ch = s.charAt(i);
            if (isOpenBracket(ch)) {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    return false;
                } else {
                    if (getOpenBracketFor(ch) == st.peek()) {
                        st.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if (!st.isEmpty()) {
            // still stack contains un-balanced bracket
            return false;
        }
        return true;
    }

    /**
     * TC: O(1)
     * SC: O(1)
     */
    private char getOpenBracketFor(char ch) {
        if (ch == ')') {
            return '(';
        } else if (ch == '}') {
            return '{';
        } else {
            return '[';
        }
    }

    /**
     * TC: O(1)
     * SC: O(1)
     */
    private boolean isOpenBracket(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }
}
