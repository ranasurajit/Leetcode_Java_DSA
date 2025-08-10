class Solution {
    /**
     * Approach : Using StringBuilder Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public String removeOuterParentheses(String s) {
        int n = s.length();
        int counter = 0;
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            char ch = s.charAt(i);
            if (ch == ')') {
                counter--;
            }
            if (counter != 0) {
                sb.append(ch);
            }
            if (ch == '(') {
                counter++;
            }
        }
        return sb.toString();
    }
}
