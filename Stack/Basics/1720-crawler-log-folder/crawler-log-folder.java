class Solution {
    public int minOperations(String[] logs) {
        Stack<String> st = new Stack<String>();
        for (String s : logs) {
            if (s.equals("../")) {
                if (st.isEmpty()) {
                    continue;
                } else {
                    st.pop();
                }
            } else if (s.equals("./")) {
                continue;
            } else {
                st.push("folder");
            }
        }
        int steps = 0;
        while (!st.isEmpty()) {
            st.pop();
            steps++;
        }
        return steps;
    }
}
