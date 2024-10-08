class Solution {
    /**
     * TC: O(N)
     * SC: O(N)
     */
    public int minSwaps(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<Character>(); // SC: O(N / 2)
        for (int i = 0; i < n; i++) { // TC: O(N)
            char ch = s.charAt(i);
            if (!st.isEmpty() && ch == ']' && st.peek() == '[') {
                st.pop();
            } else {
                if (ch == '[') {
                    st.push(ch);
                }
            }
        }
        return (st.size() + 1) / 2;
    }
}
