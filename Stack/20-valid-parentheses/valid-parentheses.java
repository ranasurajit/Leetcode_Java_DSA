class Solution {
    public boolean isValid(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> st = new Stack<Character>();
        for (char c : ch) {
            if (isOpen(c)) {
                st.add(c);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                char compChar = st.pop();
                if (getOpenParenthesis(c) != compChar) {
                    return false;
                }
            }
        }
        if (!st.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean isOpen(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private char getOpenParenthesis(char c) {
        char result = 'o';
        if (c == ')') {
            result = '(';
        } else if (c == '}') {
            result = '{';
        } else if (c == ']') {
            result = '[';
        }
        return result;
    }
}