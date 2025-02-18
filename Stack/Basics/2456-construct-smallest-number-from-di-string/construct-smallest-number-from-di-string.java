class Solution {
    /**
     * Using Stack and StringBuilder
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        int count = 1;
        Stack<Character> st = new Stack<Character>(); // SC: O(N)
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= n; i++) { // TC: O(N + 1)
            // as result will be of length (n + 1)
            st.push((char) (count + '0'));
            count++;
            if (i == n || pattern.charAt(i) == 'I') {
                while (!st.isEmpty()) {
                    result.append(st.pop());
                }
            }
        }
        return result.toString();
    }
}
