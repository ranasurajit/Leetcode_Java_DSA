class Solution {
    public int maximumGain(String s, int x, int y) {
        int[] maxPoints = {0};
        if (x > y) {
            // remove ab first and then ba
            s = calculate(s, "ab", maxPoints, x);
            s = calculate(s, "ba", maxPoints, y);
        } else {
            // remove ba first and then ab
            s = calculate(s, "ba", maxPoints, y);
            s = calculate(s, "ab", maxPoints, x);
        }
        return maxPoints[0];
    }

    private String calculate(String s, String sub, int[] maxPoints, int points) {
        Stack<Character> st = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (st.isEmpty()) {
                st.add(s.charAt(i));
            } else {
                if (s.charAt(i) == sub.charAt(1) && st.peek() == sub.charAt(0)) {
                    st.pop();
                    maxPoints[0] += points;
                } else {
                    st.add(s.charAt(i));
                }
            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
