class Solution {
    /**
     * Using Stack Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<Character>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (isOpenParentheses(s.charAt(i))) {
                st.push(s.charAt(i));
            } else {
                if (st.isEmpty()) {
                    return false;
                } else {
                    if (st.pop() != isParenthesesClosedFor(s.charAt(i))) {
                        return false;
                    }
                }
            }
        }
        if (!st.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * TC: O(1)
     * SC: O(1)
     */
    private static boolean isOpenParentheses(Character ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }

    /**
     * TC: O(1)
     * SC: O(1)
     */
    private static Character isParenthesesClosedFor(Character ch) {
        if (ch == ')') {
            return '(';
        } else if (ch == '}') {
            return '{';
        } else if (ch == ']') {
            return '[';
        } else {
            return '(';
        }
    }
}
