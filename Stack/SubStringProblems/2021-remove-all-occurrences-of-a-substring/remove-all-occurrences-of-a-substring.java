class Solution {
    /**
     * Approch I : Using StringBuilder
     *
     * TC: O(M x N)
     * SC: O(M)
     */
    public String removeOccurrences(String s, String part) {
        int m = s.length();
        int n = part.length();
        StringBuilder sb = new StringBuilder(); // SC: O(M)
        for (int i = 0; i < m; i++) { // TC: O(M)
            sb.append(s.charAt(i));
            int startIndex = sb.length() - n;
            int len = sb.length();
            if (len >= n && 
                sb.substring(startIndex, len).toString().equals(part)) { // TC: O(N)
                sb.setLength(len - n);
            }
        }
        return sb.toString();
    }

    /**
     * Approch II : Using Stacks
     *
     * TC: O(M x N)
     * SC: O(M + N)
     */
    public String removeOccurrencesApproachII(String s, String part) {
        int m = s.length();
        int n = part.length();
        Stack<Character> st = new Stack<Character>(); // SC: O(M)
        for (int i = 0; i < m; i++) { // TC: O(M)
            st.push(s.charAt(i));
            if (st.size() >= n) {
                modifyIfPresent(st, part, n); // TC: O(N), SC: O(N)
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }

    /**
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    private void modifyIfPresent(Stack<Character> st, String part, int n) {
        Stack<Character> compareSt = new Stack<Character>(); // SC: O(N)
        boolean isValid = true;
        compareSt.addAll(st);
        for (int i = n - 1; i >= 0; i--) { // TC: O(N)
            if (part.charAt(i) != compareSt.peek()) {
                isValid = false;
                break;
            }
            compareSt.pop();
        }
        if (isValid) {
            for (int i = 0; i < n; i++) { // TC: O(N)
                st.pop();
            }
        }
    }
}
