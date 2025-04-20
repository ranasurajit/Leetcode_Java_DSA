class Solution {
    /**
     * Approach : Using Stack Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public boolean backspaceCompare(String s, String t) {
        s = eliminateBackspace(s); // TC: O(N), SC: O(N)
        t = eliminateBackspace(t); // TC: O(N), SC: O(N)
        return s.equals(t);
    }

    /**
     * Using Stack Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    private String eliminateBackspace(String str) {
        Stack<Character> st = new Stack<Character>(); // SC: O(N)
        int n = str.length();
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (!st.isEmpty() && str.charAt(i) == '#') {
                st.pop();
            } else if (str.charAt(i) != '#') {
                st.push(str.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) { // TC: O(N)
            sb.append(st.pop());
        }
        return sb.toString();
    }
}
