class Solution {
    /**
     * Using Stacks Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<Character>(); // SC: O(N)
        int n = s.length();
        for (int i = 0; i < n; i++) { // TC: O(N)
            char ch = s.charAt(i);
            if (!st.isEmpty() && Character.isDigit(ch)) {
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
