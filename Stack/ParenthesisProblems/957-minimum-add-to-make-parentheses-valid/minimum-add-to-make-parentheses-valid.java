class Solution {
    /**
     * Approach I : Using Stack Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public int minAddToMakeValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<Character>(); // TC: O(N)
        int i = 0;
        int count = 0;
        while (i < n) { // TC: O(N)
            char ch = s.charAt(i);
            if (!st.isEmpty() && ch == ')' && st.peek() == '(') {
                // remove the last insert element if it balances the paranthesis
                st.pop();
            } else {
                st.push(ch);
            }
            i++;
        }
        return st.size();
    }
}
