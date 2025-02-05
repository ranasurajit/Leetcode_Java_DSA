class Solution {
    /**
     * Using Stack Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<Integer>();
        int num = 0;
        int result = 0;
        int sign = 1;
        for (int i = 0; i < n; i++) { // TC: O(N)
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                // keep forming the number
                num = num * 10 + (ch - '0');
            } else if (ch == '+') {
                // store the num into result
                result += (num * sign);
                // reset the num
                num = 0;
                sign = 1;
            } else if (ch == '-') {
                // store the num into result
                result += (num * sign);
                // reset the num
                num = 0;
                sign = -1;
            } else if (ch == '(') {
                // push history to Stack
                st.push(result);
                st.push(sign);
                // reset result and num
                result = 0;
                num = 0;
                sign = 1;
            } else if (ch == ')') {
                // store the num into result
                result += (num * sign);
                num = 0;
                int lastSign = st.pop();
                int lastResult = st.pop();
                result = lastSign * result;
                result += lastResult;
            } else {
                continue;
            }
        }
        if (num > 0) {
            result += (num * sign);
        }
        return result;
    }   
}
