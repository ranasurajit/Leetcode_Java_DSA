class Solution {
    /**
     * Approach : Using Stack Approach
     *
     * TC: O(N + K)
     * SC: O(N)
     */
    public String reversePrefix(String word, char ch) {
        int n = word.length();
        Stack<Character> st = new Stack<Character>(); // TC: O(K)
        StringBuilder sb = new StringBuilder(); // SC: O(N - K)
        int idx = -1;
        for (int i = 0; i < n; i++) { // TC: O(K)
            st.push(word.charAt(i));
            if (word.charAt(i) == ch) {
                idx = i + 1;
                break;
            }
        }
        if (idx == -1) {
            return word;
        }
        while (!st.isEmpty()) { // TC: O(K)
            sb.append(st.pop());
        }
        for (int i = idx; i < n; i++) { // TC: O(N - K)
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }
}
