class Solution {
    /**
     * Using Stack Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public String removeStars(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<Character>(); // SC: O(N)
        for (int i = 0; i < n; i++) {                 // TC: O(N)
            char ch = s.charAt(i);
            if (st.isEmpty() && ch != '*') {
                st.push(ch);
            } else {
                if (ch == '*') {
                    st.pop();
                } else {
                    st.push(ch);
                }
            }
        }
        String result = "";
        while (!st.isEmpty()) {
            result = st.pop() + result;
        }
        return result;
    }
}
