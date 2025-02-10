class Solution {
    /**
     * Using StringBuilder Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        int n = s.length();
        for (char ch : s.toCharArray()) { // TC: O(N)
            if (Character.isDigit(ch) && sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    /**
     * Using Stacks Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public String clearDigitsUsingStack(String s) {
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
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) { // TC: O(N)
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }
}
