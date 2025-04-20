class Solution {
    /**
     * Approach : Using Stack Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public String makeGood(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<Character>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (!st.isEmpty() && Math.abs(st.peek() - s.charAt(i)) == 32) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        while (!st.isEmpty()) { // TC: O(N)
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }
}
