class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int p = 0; // pointer for pushed array
        int q = 0; // pointer for popped array
        Stack<Integer> st = new Stack<Integer>();
        while (p < pushed.length && q < popped.length) {
            if (st.isEmpty()) {
                st.push(pushed[p]);
                p++;
            } else {
                if (st.peek() == popped[q]) {
                    st.pop();
                    q++;
                } else {
                    st.push(pushed[p]);
                    p++;
                }
            }
        }
        while (q < popped.length) {
            if (st.peek() == popped[q]) {
                st.pop();
            }
            q++;
        }
        return st.isEmpty();
    }
}
