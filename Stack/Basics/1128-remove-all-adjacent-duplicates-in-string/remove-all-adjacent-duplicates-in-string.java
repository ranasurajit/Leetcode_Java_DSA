class Solution {
    /**
     * Using Stack Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     * 
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<Character>(); // SC: O(N)
        for (int i = n - 1; i >= 0; i--) {            // TC: O(N)
            char ch = s.charAt(i);
            if (!st.isEmpty() && ch == st.peek()) {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {                      // TC: O(N)
            sb.append(st.pop());
        }
        return sb.toString();
    }
}
