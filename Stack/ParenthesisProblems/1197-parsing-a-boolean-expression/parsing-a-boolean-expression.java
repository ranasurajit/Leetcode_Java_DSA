class Solution {
    /**
     * TC: O(2N) ~ O(N)
     * SC: O(N)
     */
    public boolean parseBoolExpr(String expression) {
        int n = expression.length();
        Stack<Character> st = new Stack<Character>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            char ch = expression.charAt(i);
            if (ch == ',') {
                continue;
            } else if (ch == ')') {
                ArrayList<Character> list = new ArrayList<Character>();
                // pop out all the characters backward till we encounter '('
                while (!st.isEmpty() && st.peek() != '(') {
                    list.add(st.pop());
                }
                st.pop(); // pop out '(' as well
                char operator = st.pop();
                // operator can be !, &, |
                st.push(solveOperation(list, operator)); // TC: O(N) (additive to for loop) 
            } else {
                st.push(ch);
            }
        }
        return st.pop() == 't' ? true : false;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     */
    private char solveOperation(ArrayList<Character> list, char operator) {
        if (operator == '!') {
            return list.get(0) == 't' ? 'f' : 't';
        } else if (operator == '&') {
            for (Character c : list) {
                if (c == 'f') {
                    // any item if false makes entire operation false for '&' operation
                    return 'f';
                }
            }
            return 't';
        } else {
            for (Character c : list) {
                if (c == 't') {
                    // any item if true makes entire operation true for '|' operation
                    return 't';
                }
            }
            return 'f';
        }
    }
}
