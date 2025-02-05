class Solution {
    /**
     * Using Stack Approach
     *
     * TC: O(N)
     * SC: O(N)
     * 
     * @param s
     * @return
     */
    public String removeStars(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<Character>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            char ch = s.charAt(i);
            if (!st.isEmpty() && ch == '*') {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        String result = "";
        while (!st.isEmpty()) { // TC: O(N)
            result = st.pop() + result;
        }
        return result;
    }
}
