class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<Character>();
        int i = 0;
        int count = 0;
        while (i < n) {
            if (st.isEmpty()) {
                st.push(s.charAt(i));
            } else {
                if (s.charAt(i) == ')' && st.peek() == '(') {
                    st.pop();
                } else {
                    if (s.charAt(i) == '(') {
                        st.push(s.charAt(i));
                    } else {
                        count++;
                    }
                }
            }
            i++;
        }
        while (!st.isEmpty()) {
            st.pop();
            count++;
        }
        return count;
    }
}
