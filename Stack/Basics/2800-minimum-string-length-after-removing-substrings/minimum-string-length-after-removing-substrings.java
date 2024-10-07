class Solution {
    /**
     * TC: O(N)
     * SC: O(N)
     */
    public int minLength(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<Character>(); // SC: O(N)
        for (int i = n - 1; i >= 0; i--) { // TC: O(N)
            char current = s.charAt(i);
            if (st.isEmpty()) {
                st.push(current);
            } else {
                if (current == 'A' || current == 'C') {
                    char previous = st.peek();
                    if ((current == 'A' && previous == 'B') || (current == 'C' && previous == 'D')) {
                        st.pop();
                    } else {
                        st.push(current);
                    }
                } else {
                    st.push(current);
                }
            }
        }
        return st.size();
    }
}
