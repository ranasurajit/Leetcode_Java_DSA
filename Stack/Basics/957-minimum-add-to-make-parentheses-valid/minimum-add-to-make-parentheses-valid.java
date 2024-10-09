class Solution {
    /**
     * Without using Stack (Memory Efficient)
     * TC: O(N)
     * SC: O(1)
     */
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int open = 0;
        int close = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            char ch = s.charAt(i);
            if (ch == '(') {
                open++;
            } else if (ch == ')') {
                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }
        return open + close;
    }

    /**
     * Using Stack
     * TC: O(N)
     * SC: O(N)
     */
    public int minAddToMakeValidBetter(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<Character>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            char ch = s.charAt(i);
            if (!st.isEmpty() && ch == ')' && st.peek() == '(') {
                st.pop(); // negating the balanced parentheses
            } else {
                st.push(ch);
            }
        }
        return st.size();
    }
}
